package problems;

import java.util.ArrayList;
import java.util.List;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class BSTNodesKDistanceImpl<T extends Comparable<T>> extends BSTImpl<T> implements BSTNodesKDistance<T> {

    @Override
    public List<T> nodesAtDistance(T value, int distance) {
         ArrayList<T> list = new ArrayList<>();
        ArrayList<T> control = new ArrayList<>();
        control.add(value);
        if (search(value).isEmpty()) {
            return null;
        }

        nodesAtDistanceNode(value, distance, control, list);
        return list;
    }

    private void nodesAtDistanceNode(T value, int distance, ArrayList<T> control, ArrayList<T> list) {
       BSTNode<T> node = search(value);
       if (distance == 1) {
        if (node.getParent() != null && !node.getParent().isEmpty()
                && !control.contains(node.getParent().getData())) {
            list.add(node.getParent().getData());
        }

        if (node.getLeft() != null && !node.getLeft().isEmpty() && !control.contains(node.getLeft().getData())) {
            list.add(node.getLeft().getData());
        }

        if (node.getRight() != null && !node.getRight().isEmpty() && !control.contains(node.getRight().getData())) {
            list.add(node.getRight().getData());
        }

    } else if (distance > 1) {
        if (node.getParent() != null && !node.getParent().isEmpty()) {
            control.add(node.getParent().getData());
            nodesAtDistanceNode(node.getParent().getData(), distance - 1, control, list);

        }

        if ((node.getLeft() != null && !node.getLeft().isEmpty())) {
            control.add(node.getLeft().getData());
            nodesAtDistanceNode(node.getLeft().getData(), distance - 1, control, list);
        }

        if ((node.getRight() != null && !node.getRight().isEmpty())) {
            control.add(node.getRight().getData());
            nodesAtDistanceNode(node.getRight().getData(), distance - 1, control, list);
        }

    }
    }    
}
