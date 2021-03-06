package tree;

import java.util.ArrayList;
import java.util.List;

public class Huffman {

    private HuffmanNode mRoot;	// 根结点
    /*
     * 创建Huffman树
     *
     * @param 权值数组
     */
    public Huffman(int[] a) {
        HuffmanNode parent = null;
        MinHeap heap;

        // 建立数组a对应的最小堆
        heap = new MinHeap(a);

        for(int i=0; i<a.length-1; i++) {
            HuffmanNode left = heap.dumpFromMinimum();  // 最小节点是左孩子
            HuffmanNode right = heap.dumpFromMinimum(); // 其次才是右孩子

            // 新建parent节点，左右孩子分别是left/right；
            // parent的大小是左右孩子之和
            parent = new HuffmanNode(left.key+right.key, left, right, null);
            left.parent = parent;
            right.parent = parent;

            // 将parent节点数据拷贝到"最小堆"中
            heap.insert(parent);
        }

        mRoot = parent;

        // 销毁最小堆
        heap.destroy();
    }

    /*
     * 前序遍历"Huffman树"
     */
    private void preOrder(HuffmanNode tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍历"Huffman树"
     */
    private void inOrder(HuffmanNode tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }


    /*
     * 后序遍历"Huffman树"
     */
    private void postOrder(HuffmanNode tree) {
        if(tree != null)
        {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /*
     * 销毁Huffman树
     */
    private void destroy(HuffmanNode tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
    }

    public void destroy() {
        destroy(mRoot);
        mRoot = null;
    }

    /*
     * 打印"Huffman树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(HuffmanNode tree, int key, int direction) {

        if(tree != null) {

            if(direction==0)	// tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else				// tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }


    public static class HuffmanNode implements Comparable<HuffmanNode>, Cloneable {
        protected int key;              // 权值
        protected HuffmanNode left;     // 左孩子
        protected HuffmanNode right;    // 右孩子
        protected HuffmanNode parent;   // 父结点

        protected HuffmanNode(int key, HuffmanNode left, HuffmanNode right, HuffmanNode parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public Object clone() {
            Object obj=null;
            try {
                obj = super.clone();//Object 中的clone()识别出你要复制的是哪一个对象。
            } catch(CloneNotSupportedException e) {
                System.out.println(e.getMessage());
            }
            return obj;
        }

        @Override
        public int compareTo(HuffmanNode obj) {
            return this.key - obj.key;
        }
    }

    public static class MinHeap {

        private List<HuffmanNode> mHeap;		// 存放堆的数组

        /*
         * 创建最小堆
         *
         * 参数说明：
         *     a -- 数据所在的数组
         */
        protected MinHeap(int[] a) {
            mHeap = new ArrayList<>();
            // 初始化数组
            for (int j : a) {
                HuffmanNode node = new HuffmanNode(j, null, null, null);
                mHeap.add(node);
            }

            // 从(size/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个最小堆。
            for (int i = a.length / 2 - 1; i >= 0; i--)
                filterDown(i, a.length-1);
        }

        /*
         * 最小堆的向下调整算法
         *
         * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
         *
         * 参数说明：
         *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
         *     end   -- 截至范围(一般为数组中最后一个元素的索引)
         */
        protected void filterDown(int start, int end) {
            int c = start; 	 	// 当前(current)节点的位置
            int l = 2*c + 1; 	// 左(left)孩子的位置
            HuffmanNode tmp = mHeap.get(c);	// 当前(current)节点

            while(l <= end) {
                // "l"是左孩子，"l+1"是右孩子
                if(l < end && (mHeap.get(l).compareTo(mHeap.get(l+1))>0))
                    l++;		// 左右两孩子中选择较小者，即mHeap[l+1]

                int cmp = tmp.compareTo(mHeap.get(l));
                if(cmp <= 0)
                    break;		//调整结束
                else {
                    mHeap.set(c, mHeap.get(l));
                    c = l;
                    l = 2*l + 1;
                }
            }
            mHeap.set(c, tmp);
        }

        /*
         * 最小堆的向上调整算法(从start开始向上直到0，调整堆)
         *
         * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
         *
         * 参数说明：
         *     start -- 被上调节点的起始位置(一般为数组中最后一个元素的索引)
         */
        protected void filterUp(int start) {
            int c = start;			// 当前节点(current)的位置
            int p = (c-1)/2;		// 父(parent)结点的位置
            HuffmanNode tmp = mHeap.get(c);	// 当前(current)节点

            while(c > 0) {
                int cmp = mHeap.get(p).compareTo(tmp);
                if(cmp <= 0)
                    break;
                else {
                    mHeap.set(c, mHeap.get(p));
                    c = p;
                    p = (p-1)/2;
                }
            }
            mHeap.set(c, tmp);
        }

        /*
         * 将node插入到二叉堆中
         */
        protected void insert(HuffmanNode node) {
            int size = mHeap.size();

            mHeap.add(node);	// 将"数组"插在表尾
            filterUp(size);		// 向上调整堆
        }

        /*
         * 交换两个HuffmanNode节点的全部数据
         */
        private void swapNode(int i, int j) {
            HuffmanNode tmp = mHeap.get(i);
            mHeap.set(i, mHeap.get(j));
            mHeap.set(j, tmp);
        }

        /*
         * 新建一个节点，并将最小堆中最小节点的数据复制给该节点。
         * 然后除最小节点之外的数据重新构造成最小堆。
         *
         * 返回值：
         *     失败返回null。
         */
        protected HuffmanNode dumpFromMinimum() {
            int size = mHeap.size();

            // 如果"堆"已空，则返回
            if(size == 0)
                return null;

            // 将"最小节点"克隆一份，将克隆得到的对象赋值给node
            HuffmanNode node = (HuffmanNode)mHeap.get(0).clone();

            // 交换"最小节点"和"最后一个节点"
            mHeap.set(0, mHeap.get(size-1));
            // 删除最后的元素
            mHeap.remove(size-1);

            if (mHeap.size() > 1)
                filterDown(0, mHeap.size()-1);

            return node;
        }

        // 销毁最小堆
        protected void destroy() {
            mHeap.clear();
            mHeap = null;
        }
    }
}
