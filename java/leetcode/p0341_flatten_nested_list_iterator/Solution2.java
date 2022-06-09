package leetcode.p0341_flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    
    class NestedIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        
        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> result = new LinkedList<>();
            traverse(nestedList, result);
            iterator = result.iterator();
        }

        private void traverse(List<NestedInteger> nestedList, List<Integer> result) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    result.add(nestedInteger.getInteger());
                } else {
                    traverse(nestedInteger.getList(), result);    
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


}

