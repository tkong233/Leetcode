package Interviews.Duolingo;

import java.util.*;

public class FindBestLanguage {
    /*
        Give:
            - a set of languages
            - a mapping of individuals to what languages they speak
            - a list of friend relationships

        Find a language that we must teach to the fewest number of individuals
        for all connected individuals to be able to communicate.
     */

    void findBestLanguage(Set<String> languages,
                          Map<String, Set<String>> personLanguageMap,
                          Map<String, Set<String>> friendshipMap) {
        Set<String> friendsCantCommunicateSet = new HashSet<>();
        getFriendsCantCommunicate(friendsCantCommunicateSet, friendshipMap, personLanguageMap);

        int minPersonToTeach = Integer.MAX_VALUE;
        String bestLanguage = null;

        for (String language : languages) {
            int personToTeach = getPersonToTeach(language, friendsCantCommunicateSet, personLanguageMap);

            if (personToTeach < minPersonToTeach) {
                minPersonToTeach = personToTeach;
                bestLanguage = language;
            }
        }

        System.out.println("Best language: " + bestLanguage);
        System.out.println("People to teach: " + minPersonToTeach);
    }

    private void getFriendsCantCommunicate(Set<String> friendsCantCommunicateSet,
                                           Map<String, Set<String>> friendshipMap,
                                           Map<String, Set<String>> personLanguageMap) {
        for (Map.Entry<String, Set<String>> entry : friendshipMap.entrySet()) {
            String person = entry.getKey();
            Set<String> friends = entry.getValue();

            for (String friend : friends) {
                if (!canCommunicate(person, friend, personLanguageMap)) {
                    friendsCantCommunicateSet.add(friend);
                    friendsCantCommunicateSet.add(person);
                }
            }
        }
    }

    private boolean canCommunicate(String person,
                                   String friend,
                                   Map<String, Set<String>> personLanguageMap) {
        Set<String> personLanguages = personLanguageMap.get(person);
        Set<String> friendLanguages = personLanguageMap.get(friend);

        for (String language : personLanguages) {
            if (friendLanguages.contains(language)) {
                return true;
            }
        }

        return false;

    }

    private int getPersonToTeach(String languageToTeach,
                                 Set<String> friendsCantCommunicate,
                                 Map<String, Set<String>> personLanguageMap) {
        Set<String> personToTeach = new HashSet<>();

        for (String friend : friendsCantCommunicate) {
            Set<String> languagesSpoken = personLanguageMap.get(friend);
            if (!languagesSpoken.contains(languageToTeach)) {
                personToTeach.add(friend);
            }
        }

        return personToTeach.size();
    }

    public static void main(String[] args) {
        FindBestLanguage solution = new FindBestLanguage();
        Set<String> languages = new HashSet<>(Arrays.asList("Korean", "French", "Romanian"));
        Map<String, Set<String>> personLanguageMap = new HashMap<>();
        personLanguageMap.put("Alice", new HashSet<>(Arrays.asList("Korean", "French")));
        personLanguageMap.put("Chris", new HashSet<>(Arrays.asList("Korean")));
        personLanguageMap.put("Bob", new HashSet<>(Arrays.asList("Romanian")));
        personLanguageMap.put("Danielle", new HashSet<>(Arrays.asList("Romanian")));


        Map<String, Set<String>> friendshipMap = new HashMap<>();
        friendshipMap.put("Alice", new HashSet<>(Arrays.asList("Chris", "Bob")));
        friendshipMap.put("Chris", new HashSet<>(Arrays.asList("Alice", "Bob")));
        friendshipMap.put("Bob", new HashSet<>(Arrays.asList("Alice", "Chris", "Danielle")));
        friendshipMap.put("Alice", new HashSet<>(Arrays.asList("Chris", "Bob")));
        friendshipMap.put("Danielle", new HashSet<>(Arrays.asList("Bob")));

        solution.findBestLanguage(languages, personLanguageMap, friendshipMap);
    }
}
