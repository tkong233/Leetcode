package Interviews.Databricks;
import java.util.*;

public class StringManipulation {
    class BlockList {
        class Block {
            List<Character> data;
            public Block() {
                data = new ArrayList<>();
            }
        }
        List<Block> blocks;
        int totalSize;
        int blockSize;

        public BlockList() {
            blocks = new ArrayList<>();
            totalSize = 0;
            blockSize = 0;
        }

        public void insert(char c, int pos) {
            // 2 cases:
            // 1. replace an existing char
            // 2. add a new char (to end)

            // case 1: block list is empty => add char to a new block
            if (blocks.isEmpty()) {
                totalSize++;
                blockSize = (int) Math.sqrt(totalSize);
                Block block = new Block();
                block.data.add(c);
                blocks.add(block);
            } else if (pos > totalSize - 1) {
                // case 2: pos doesn't have any char yet => add char to end
                totalSize++;
                blockSize = (int) Math.sqrt(totalSize);
                Block last = blocks.get(blocks.size() - 1);
                last.data.add(c);
                balance();
            } else {
                // case 3: there's already some char at pos => replace it
                int[] offset = new int[1];
                Block block = find(pos, offset);
                block.data.set(offset[0], c);
            }
            print();
        }

        public char get(int pos) {
            if (pos < 0 || pos > totalSize - 1) {
                return ' ';
            }
            int[] offset = new int[1];
            Block block = find(pos, offset);
            return block.data.get(offset[0]);
        }

        public void remove(int pos) {
            if (pos < 0 || pos > totalSize - 1) {
                return;
            }
            totalSize--;
            blockSize = (int) Math.sqrt(totalSize);
            int[] offset = new int[1];
            Block block = find(pos, offset);
            block.data.remove(offset[0]);
            balance();
            print();
        }

        // split larger blocks & merge smaller blocks
        // make sure all blocks have size of about blockSize ~ 2*blockSize
        private void balance() {
            System.out.println("balancing " + blockSize + " " + totalSize);
            // split large
            for (int i = 0; i < blocks.size(); i++) {
                Block cur = blocks.get(i);
                if (cur.data.size() > 2 * blockSize) {
                    // blockSize = 1
                    // block = 0, 1, 2
                    Block next = new Block();
                    for (int j = blockSize; j < cur.data.size(); j++) {
                        next.data.add(cur.data.get(j));
                    }
                    cur.data.subList(blockSize, cur.data.size()).clear();
                    blocks.add(i + 1, next);
                }
            }
            // merge small
            //    i
            // 11 11
            for (int i = 0; i < blocks.size() - 1; i++) {
                Block cur = blocks.get(i);
                Block next = blocks.get(i + 1);
                if (cur.data.size() + next.data.size() < 2 * blockSize) {
                    for (int j = 0; j < next.data.size(); j++) {
                        cur.data.add(next.data.get(j));
                    }
                    blocks.remove(i + 1);
                }
            }
        }

        // assumes there exists a block correspond to pos
        private Block find(int pos, int[] offset) {
            int index = 0;
            Block cur = blocks.get(index);
            // [0, 1] => found because curSize == pos + 1
            // if curSize >= pos + 1 => found
            while (cur.data.size() < pos + 1) {
                pos -= cur.data.size();
                index++;
                cur = blocks.get(index);
            }
            offset[0] = pos;
            return cur;
        }

        public void print() {
            for (Block b : blocks) {
                for (char c : b.data) {
                    System.out.print(c);
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StringManipulation solution = new StringManipulation();
        StringManipulation.BlockList blockList = solution.new BlockList();
        blockList.insert('b', 0);
        blockList.insert('c', 1);
        blockList.insert('d', 2);
        blockList.insert('e', 3);
        blockList.insert('f', 6);
        blockList.insert('g', 7);
        System.out.println(blockList.get(0));
        System.out.println(blockList.get(4));
        blockList.remove(0);
        System.out.println(blockList.get(2));
        blockList.remove(1);
        blockList.remove(2);
    }
}
