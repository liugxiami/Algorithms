package com.ccsi.tree;

import java.util.*;

/**
 * Created by gxliu on 2016/11/21.
 */
public class Tree {
    public static void main(String[] args) {
        int[] arr={1,2,5,4,3,6,7};
        TreeNode res=buildBST(arr,0,arr.length-1);

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);

        reverseTree(res);
    }
    //count complete binary tree nodes
    //左深=右深，那么必是满二叉树，满二叉树算节点数；左深=右深（+1），递归。
    public static int countCompleteBinaryTreeNodes(TreeNode root){
        if(root==null)return 0;

        int leftHeight=0;
        TreeNode curr=root.left;
        while(curr!=null){
            leftHeight++;
            curr=curr.left;
        }

        int rightHeight=0;
        curr=root.right;
        while(curr!=null){
            rightHeight++;
            curr=curr.right;
        }

        if(leftHeight==rightHeight){
            return (1<<(leftHeight+1))-1;
        }else{
            return 1+countCompleteBinaryTreeNodes(root.left)+countCompleteBinaryTreeNodes(root.right);
        }

    }
    //count full binary tree nodes 满二叉树的节点数是2^高度-1，所以先算出高度，再数学方法算出节点数
    public static int countFullBinaryTreeNodes(TreeNode root){
        if(root==null)return 0;
        int height=0;
        TreeNode curr=root;
        while(curr!=null){
            height++;
            curr=curr.left;   //or curr.right,满二叉树的特点是任意节点的左右子树的深度（高度）是一样的。
        }
        return (1<<height)-1;
    }
    //count numbers of Nodes
    public static int countNodes(TreeNode root){
        if(root==null)return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    //backtracking
    public static void bt(List<List<TreeNode>> bag, Stack<TreeNode> path, TreeNode curr){
        //因为压栈是做过检查，不可能出现curr==null的情况，所以不要做判断
        path.push(curr);
        if(curr.left==null&&curr.right==null){
            bag.add(new ArrayList<>(path));
        }else{
            if(curr.left!=null)bt(bag,path,curr.left);
            if(curr.right!=null)bt(bag,path,curr.right);
        }
        path.pop();
    }
    //利用loop来实现backtracking，双queue来实现。
    public static List<List<TreeNode>> findAllPath(TreeNode root){
        List<List<TreeNode>> result=new LinkedList<>();   //返回用的result
        List<TreeNode> init=new LinkedList<>();           //起始path
        //准备两个queue，一个存node，一个存path
        Queue<List<TreeNode>> pathQueue=new LinkedList<>();
        Queue<TreeNode> nodeQueue=new LinkedList<>();

        init.add(root);
        //node和起始path offer进queue
        nodeQueue.offer(root);
        pathQueue.offer(init);
        //BFS相通的步骤
        while(!nodeQueue.isEmpty()){
            List<TreeNode> path=pathQueue.poll();    //都poll（）出来
            TreeNode temp=nodeQueue.poll();

            if(temp.left==null&&temp.right==null){   //如果到叶子节点了，也就是找到路径了，做点什么事呢？
                result.add(path);
            }else{
                if(temp.left!=null){                 //如果没结束，那么要更新path
                    List<TreeNode> newPath=new LinkedList<>(path);
                    newPath.add(temp.left);          //更新path
                    pathQueue.offer(newPath);        //再进queue
                    nodeQueue.offer(temp.left);
                }
                if(temp.right!=null){                //同上
                    List<TreeNode> newPath=new LinkedList<>(path);
                    newPath.add(temp.right);
                    pathQueue.offer(newPath);
                    nodeQueue.offer(temp.right);
                }
            }
        }
        return result;
    }
    //BFS
    public static void BFS(TreeNode root){
        //if(root==null)return; 无须判断，因为不会有null传进来
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.println(temp.val);

            if(temp.left!=null)queue.offer(temp.left);
            if(temp.right!=null)queue.offer(temp.right);
        }
    }
    //recursion DFS
    public static void DFS(TreeNode curr){
        if(curr==null)return;
        System.out.println(curr.val);    //pre-order DFS
        DFS(curr.left);                  //如果没有前面的if(curr==null)return;此处需要判断是否为空。
        //System.out.println(curr.val);  //in-order DFS
        DFS(curr.right);
        //System.out.println(curr.val);  //post-order DFS
    }
    //Loop DFS 写法与BFS基本一样，用stack替代了queue，并且right和left颠倒了位置
    public static void loopDFS(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.println(temp.val);
            if(temp.right!=null)stack.push(temp.right); //pre-order right 和 left颠倒了位置
            if(temp.left!=null)stack.push(temp.left);

        }
    }
    //从上往下build树
    public static TreeNode buildTreeTopDown(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        //root.right.right=new TreeNode(7);
        return root;
    }
    //从下往上build树
    public static TreeNode buildTreeBottomUp(){
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n2=new TreeNode(2,n4,n5);
        TreeNode n3=new TreeNode(3,n6,n7);
        TreeNode root= new TreeNode(1,n2,n3);
        return root;
    }
    //判断一个数是否左右对称,双queue BFS 方法
    public static boolean isSymmetryBFS(TreeNode curr){
        if(curr==null)return true;

        Queue<TreeNode> leftQ=new LinkedList<>();
        Queue<TreeNode> rightQ=new LinkedList<>();
        leftQ.offer(curr.left);
        rightQ.offer(curr.right);

        while(!leftQ.isEmpty()&&!rightQ.isEmpty())
        {
            TreeNode leftNodes=leftQ.poll();
            TreeNode rightNodes=rightQ.poll();
            if(leftNodes==null&&rightNodes==null)return true;
            if(leftNodes==null||rightNodes==null)return false;
            if(leftNodes.val!=rightNodes.val)return false;
            else {
                leftQ.offer(leftNodes.left);
                rightQ.offer(rightNodes.right);
                leftQ.offer(leftNodes.right);
                rightQ.offer(rightNodes.left);
            }
        }
        return true;
    }
    //判断一个数是否左右对称,DFS 方法
    public static boolean isSymmetryDFS(TreeNode root){
        if(root==null)return true;
        TreeNode leftTree=root.left;
        TreeNode rightTree=root.right;
        return inner_isSymmetryDFS(leftTree,rightTree);
    }
    public static boolean inner_isSymmetryDFS(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;
        else{
            return inner_isSymmetryDFS(left.left,right.right)&&inner_isSymmetryDFS(left.right,right.left);
        }
    }
    //判断两棵树是否一样 DFS
    public static boolean sameDFS(TreeNode leftTree, TreeNode rightTree){
        if(leftTree==null&&rightTree==null)return true;
        if(leftTree==null||rightTree==null)return false;
        if(leftTree.val!=rightTree.val)return false;
        else{
            return sameDFS(leftTree.left,rightTree.left)&& sameDFS(leftTree.right,rightTree.right);
        }
    }
    //判断两棵树是否一样 BFS
    public static boolean sameBFS(TreeNode leftTree,TreeNode rightTree){

        Queue<TreeNode> leftQ=new LinkedList<>();
        Queue<TreeNode> rightQ=new LinkedList<>();

        leftQ.offer(leftTree);
        rightQ.offer(rightTree);

        while(leftQ!=null&&rightQ!=null){
            TreeNode leftNodes=leftQ.poll();
            TreeNode rightNodes=rightQ.poll();
            if(leftNodes==null&&rightNodes==null)return true;
            if(leftNodes==null||rightNodes==null)return false;
            if(leftNodes.val!=rightNodes.val)return false;
            else{
                leftQ.offer(leftNodes.left);
                rightQ.offer(rightNodes.left);
                leftQ.offer(leftNodes.right);
                rightQ.offer(rightNodes.right);
            }
        }
        return true;

    }
    //1.reverse a tree借助辅助函数
    public static void reverse(TreeNode root){
        if(root==null)return;
        inner_reverse(root.left,root.right);
    }
    public static void inner_reverse(TreeNode left,TreeNode right){
        if(left==null&&right==null)return;
        int temp=left.val;
        left.val=right.val;
        right.val=temp;
        inner_reverse(left.left,right.right);
        inner_reverse(left.right,right.left);
    }

    //2.reverse tree
    public static void reverseTree(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return;
        else{
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;

            reverseTree(root.left);
            reverseTree(root.right);
        }

    }
    //在树找目标值存在不存在
    public static boolean search(TreeNode root,int target){
        if(root==null)return false;
        if(root.val==target)return true;
        return search(root.left,target)||search(root.right,target);
    }
    //求一颗树上的最大值
    public static int max(TreeNode curr){
        if(curr==null)return Integer.MIN_VALUE; //null值当量，求最大null=minimum,求最小值null=maximum
        return Math.max(Math.max(max(curr.right),max(curr.left)),curr.val);
    }
    //求一棵树的树高height
    public static int height(TreeNode root){
        if(root==null)return -1;    //null值当量，求树高null=-1，求树和null=0，求树积null=1
        return 1+Math.max(height(root.left),height(root.right));
    }
    //判读一棵树是不是BST,这方法不对，这只是判断了父节点与两子节点，不能保证所有左子树节点都比父节点小，右子树节点都比父节点大
    public static Boolean isBST(TreeNode root){
        if(root==null)return true;
        else{
            if(root.left!=null&&root.left.val>root.val)return false;
            if(root.right!=null&&root.right.val<root.val)return false;
            return isBST(root.left)&&isBST(root.right);
        }
    }
    //Tim老师的方法 这方法也不对
    public static boolean isBST_Tim(TreeNode root){
        if(root==null)return true;
        if(!isBST_Tim(root.left)||!isBST_Tim(root.right))return false;
        if(root.left!=null&&root.left.val>root.val)return false;
        if(root.right!=null&&root.right.val<root.val)return false;
        return true;
    }
    //判读一棵树是不是BST,利用值得范围来做，左子树的所有节点值必定是小于父节点的值，右子树的所有节点的值必定是大于父节点
    public static Boolean isBSTRight(TreeNode root){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private static Boolean isBST(TreeNode curr, int low, int high){
        if(curr==null)return true;   //low 和high不是index，此处判断node到叶子了没
        else{
            if(curr.val<=low||curr.val>=high)return false;
            return isBST(curr.left,low,curr.val)&& isBST(curr.right,curr.val,high);
        }
    }

    //pre-order序列化
    public static void pre_Serialize(List<Integer> result,TreeNode root){
        if(root==null)return;
        result.add(root.val);
        pre_Serialize(result,root.left);
        pre_Serialize(result,root.right);
    }
    //in-order序列化
    public static void in_Serialize(List<Integer> result,TreeNode root){
        if(root==null)return;
        in_Serialize(result,root.left);
        result.add(root.val);
        in_Serialize(result,root.right);
    }
    //post-order序列化
    public static void post_Serialize(List<Integer> result,TreeNode root){
        if(root==null)return;
        post_Serialize(result,root.left);
        post_Serialize(result,root.right);
        result.add(root.val);
    }

    //在BST上找一个数值,loop with Queue，典型的BST方法
    public static Boolean searchBST_loop_queue(TreeNode root,int target){
        if(root==null)return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp.val==target)return true;
            if(temp.left!=null&&target<temp.val) queue.offer(temp.left); //要注意不能将null传进queue
            if(temp.right!=null&&target>temp.val) queue.offer(temp.right);
        }
        return false;
    }
    //在BST上找一个数值,loop（方法跟在Linkedlist找值有点相似 curr=curr.next，但效率高很多）背下来
    public static Boolean searchBST_loop(TreeNode curr,int target){
        while(curr!=null){
            if(curr.val==target)return true;
            curr=(target<curr.val)?curr.left:curr.right; //curr=curr.next很相似，但有个判断
        }
        return false;
    }

    //在BST上找一个数值,recursion
    public static Boolean searchBST(TreeNode curr,int target){
        if(curr==null)return false;   //典型的递归，第一步是basic case，判断
        if(curr.val==target)return true; //recursive case
        else if(target<curr.val)return searchBST(curr.left,target); //递归
        else return searchBST(curr.right,target);
    }
    //给一个排好序的数组，建立一个BSTtree
    public static TreeNode buildBST(int[] array,int li,int hi){
        if(li==hi)return new TreeNode(array[li]);
        int mi=li+(hi-li)/2;
        TreeNode root=new TreeNode(array[mi]);
        root.left=buildBST(array,li,mi-1);
        root.right=buildBST(array,mi+1,hi);
        return root;
    }
}

