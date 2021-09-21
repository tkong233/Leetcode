package Interviews.Stripe;

import java.util.*;

public class HTTPHeader {
    List<String> parseAcceptLanguage1(String header, List<String> supportedLanguages) {
        List<String> result = new ArrayList<>();
        if (header == null || header.length() == 0 || supportedLanguages == null || supportedLanguages.size() == 0) {
            return result;
        }

        // parse header
        String[] headerLanguages = header.split(", ");
        Set<String> supportedLanguageSet = new HashSet<>(supportedLanguages);
        for (String language : headerLanguages) {
            if (supportedLanguageSet.contains(language)) {
                result.add(language);
            }
        }

        return result;
    }

    List<String> parseAcceptLanguage2(String header, List<String> supportedLanguages) {
        List<String> result = new ArrayList<>();
        if (header == null || header.length() == 0 || supportedLanguages == null || supportedLanguages.size() == 0) {
            return result;
        }

        // parse header
        String[] headerLanguages = header.split(", ");
        Set<String> supportedLanguageSet = new HashSet<>(supportedLanguages);
        for (String language : headerLanguages) {
            if (supportedLanguageSet.contains(language)) {
                result.add(language);
                supportedLanguageSet.remove(language);
                continue;
            }
            Iterator<String> iter = supportedLanguageSet.iterator();
            while (iter.hasNext()) {
                String supported = iter.next();
                if (supported.startsWith(language)) {
                    result.add(supported);
                    iter.remove();
                }
            }
        }

        return result;
    }

    List<String> parseAcceptLanguage3(String header, List<String> supportedLanguages) {
        List<String> result = new ArrayList<>();
        if (header == null || header.length() == 0 || supportedLanguages == null || supportedLanguages.size() == 0) {
            return result;
        }

        // parse header
        String[] headerLanguages = header.split(", ");
        Set<String> supportedLanguageSet = new HashSet<>(supportedLanguages);
        for (String language : headerLanguages) {
            if (supportedLanguageSet.contains(language)) {
                result.add(language);
                supportedLanguageSet.remove(language);
            }
        }

        result.addAll(supportedLanguageSet);

        return result;
    }

    public static void main(String[] args) {
        HTTPHeader solution = new HTTPHeader();
        List<String> result = solution.parseAcceptLanguage2("fr-FR, fr", Arrays.asList("e‍‍‍‍‍‍‌‌‍‍‌‍‍‌‍‌‌‍‌n-US", "fr-CA", "fr-FR"));
        System.out.println(result);

        List<String> result2 = solution.parseAcceptLanguage3("en-US, *", Arrays.asList("en-US", "fr-CA", "fr-FR"));
        System.out.println(result2);
    }
}
