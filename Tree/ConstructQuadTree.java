class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        //call function which builds the quad tree
        int size= grid.length;
        return buildQuadTree(grid, 0, 0, size);

    }

    private Node buildQuadTree(int[][] grid, int row, int column, int size) {

        //base condition (when to build tree- scan through the matrix and check if all elements are equal
        // create a new node with the value(can be anything) and isLeaf= true;
        if(isSame(row,column,grid, size))
        {
            boolean value = grid[row][column] == 1;
            Node node=new Node(value, true);
            return node;

        }
        int newSize=size/2;
        //create root(isLeaf= false)
        Node root=new Node(true, false);
        root.topLeft=buildQuadTree(grid,row, column, newSize);
        root.topRight=buildQuadTree(grid,row, column+newSize, newSize);
        root.bottomLeft=buildQuadTree(grid,row+newSize, column, newSize);
        root.bottomRight=buildQuadTree(grid,row+newSize, column+newSize, newSize);
        return root;

    }

    private boolean isSame(int row, int column, int [][] grid, int size)
    {
        //get the first value to compare
        int value=grid[row][column];

        for(int i=row;i<row+size;i++)
        {
            for(int j=column;j<column+size;j++)
            {
                if(grid[i][j]!=value)
                {
                    return false;
                }
            }
        }
        return true;

    }
}
