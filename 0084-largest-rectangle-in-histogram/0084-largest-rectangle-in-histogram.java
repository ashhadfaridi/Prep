class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int nextSmaller[] = new int[heights.length];
        int prevSmaller[] = new int[heights.length];
        for(int i = 0; i<heights.length ;i++){
              prevSmaller[i] = -1; 
            while(!s.isEmpty() && heights[s.peek()] > heights[i]){
                int top = s.pop();
                nextSmaller[top] = i;
            }

            if(!s.isEmpty()){
                prevSmaller[i] = s.peek();
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int top = s.pop();
            nextSmaller[top] = heights.length;
        }
        int max =  0;
        for(int i = 0 ; i < heights.length ; i++){
            int w = nextSmaller[i] - prevSmaller[i] -1;
            max = Math.max(max , heights[i] * w);
        }

    return max;
    }
}