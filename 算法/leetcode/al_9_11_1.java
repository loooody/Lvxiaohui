
//将有序数组转换为二叉搜索树

	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
                return null;
            }
            return buildBST(nums,0,nums.length-1);
        }
    
        private TreeNode buildBST(int[] nums,int start, int end){
            if(start<=end){
                int mid = (start + end) / 2;
                TreeNode root = new TreeNode(nums[mid]);
                root.left = buildBST(nums,start,mid-1);
                root.right = buildBST(nums,mid+1,end);
                return root;
            }else{
                return null;
            }
        }