package cn.lichao.code.jz;

public class _002StringReplace {
    /*
    如果是替换，要考虑空间复杂度
    添加 因为添加后字符串变长，所以可以从后向前加
    删除 反之变短，从前往后删。
    由于在入参中直接替换，会改变入参的值，所以本题没有直接改入参，而是新创建了一个变量
     */
    public String replaceSpace(StringBuffer str) {
        if (str==null) {
            return null;
        }
        int currentPos = 0;
        StringBuffer newStr = new StringBuffer();
        for(int i=0; i<str.length(); i++) {
            char curChar = str.charAt(i);
            if(curChar == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(curChar);
            }
        }
        return newStr.toString();
    }

}
