package cn.lichao.code.jz;

public class _001ArrayFind {
    /*
    首先这是一道查找题，并且数组有序，有序+查找 -> 二分查找

    查找想要降低时间复杂度，就是每次比较跳过的元素数量要大概率>1，二分查找也是这个思路。

    这道题中左上角最小，右下角最大。想要每次查找跳过多个元素，这里可以思考如何跳过一行或者一列。
    先找一个点作为起点，一般选一个顶点。如果选左上（最小点，或者选右下最大点）每次移动比较，淘汰后的剩下的点是一个不规则的图行，不利于后续移动。如果选择右上（或左下），每次比较能淘汰一行(同一行，左边比右边小)，或者淘汰一列（同列下面比上面小），最关键的是剩余的点还是一个矩形，能进行循环遍历

    提取做查找题的思路：
    找到一个点n，这个点n和target作比较，结果总是能去除或留下一部分数据。
     */

    public boolean Find1(int target, int [][] array) {
        boolean result = false;
        if (array.length==0 || array[0].length==0) {
            return result;
        }
        int rowCount = array.length;
        int columnCount = array[0].length;
        for(int i=0; i<array.length; i++) {
            if(array[i][0]>target){
                break;
            }
            if(array[i][columnCount-1]<target) {
                continue;
            }
            int[] row = array[i];
            int left = 0;
            int right = columnCount;
            while(left<=right) {
                int mid = (left+right)/2;
                if(row[mid]==target) {
                    return true;
                } else if(row[mid]>target) {
                    right = mid - 1;
                } else {
                    left = mid+1;
                }
            }
        }
        return result;
    }

    public boolean Find2(int target, int [][] array) {
        boolean result = false;
        if (array.length==0 || array[0].length==0) {
            return result;
        }
        int rowCount = array.length;
        int x = array[0].length-1;
        int y = 0;
        while(x>=0 && y<rowCount) {
            int currentVal = array[y][x];
            if(currentVal == target) {
                result = true;
                break;
            }
            if(currentVal>target){
                x = x-1;
            } else {
                y += 1;
            }
        }
        return result;
    }



}
