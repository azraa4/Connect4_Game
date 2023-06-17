package src;
/**
 * A class that represents the TreeNode.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-16
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a tree data structure.
 *
 * @param <T> the type of data stored in the node
 */
public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

    /**
     * Constructs a new TreeNode with the specified data.
     *
     * @param value is the data to be stored in the node
     */
    public TreeNode(T value) {
        this.data = value;
        this.children = new ArrayList<>();
    }

    /**
     * Retrieves the data stored in the node.
     *
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Retrieves the children nodes of the current node.
     *
     * @return a list of children nodes
     */
    public List<TreeNode<T>> getChildren() {
        return children;
    }

    /**
     * Adds a child node to the current node.
     *
     * @param child is the child node to be added
     */
    public void addChild(TreeNode<T> child) {
        children.add(child);
    }


}
