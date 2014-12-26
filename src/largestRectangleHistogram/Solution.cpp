class Solution
{
public:
    int largestRectangleArea(vector<int> &height)
    {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int stack[height.size() + 1], width[height.size() + 1];
        if (height.size() == 0) return 0;
        int top = 0, area = INT_MIN;
        stack[0] = 0;
        width[0] = 0;
        int newHeight;
        for (int i = 0; i <= height.size(); i++)
        {
            if (i < height.size()) newHeight = height[i];
            else newHeight = -1;
            if (newHeight >= stack[top])
            {
                stack[++top] = newHeight;
                width[top] = 1;
            }
            else
            {
                int minV = INT_MAX;
                int wid = 0;
                while (stack[top] > newHeight)
                {
                    minV = min(minV, stack[top]);
                    wid += width[top];
                    area = max(area, minV * (wid));
                    top--;
                }
                stack[++top] = newHeight;
                width[top] = wid + 1;
            }
        }
        return area;
    }
};