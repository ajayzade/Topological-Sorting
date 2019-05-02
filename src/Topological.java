import java.util.Scanner;
import java.util.Stack;

public class Topological {

    static Scanner sc = new Scanner(System.in);
    static Stack<Integer> visited = new Stack<>();
    static Stack<Integer> sorted = new Stack<>();

    public static void main(String args[]){
        int G[][] = new int[10][10];
        int e[] = new int[10];
        int V,i,j,s,c = 0,l = 0;
        boolean flag = true;
        System.out.println("Topological Sorting of Graph\n");

        //Get the graph First
        System.out.println("Enter the number of vertices in graph");
        V = sc.nextInt();
        System.out.println("Enter Adjacency matrix of graph");
        for(i = 0;i < V;i++){
            for(j = 0;j < V;j++){
                G[i][j] = sc.nextInt();
            }
        }

        //Get any vertex
        System.out.println("Enter any vertex in numbers (1,2,3...) like this");
        s = sc.nextInt();

        for (i = 0;i < e.length;i++){
            e[i] = 0;
        }

        s = s - 1;
        visited.push(s);

        //Topological Sorting
        while(flag == true){
            for (i = 0;i < V;i++){
                if (G[s][i] == 1 && e[i] == 0){
                    visited.push(i);
                    s = i;
                    break;
                }
                c++;
            }
            if (c == V){
                int a;
                if (visited.isEmpty() == false) {
                    a = visited.pop();
                    sorted.push(a);
                    e[a] = 1;
                    l++;
                    if (visited.isEmpty() == false) {
                        s = visited.peek();
                    }
                }else{
                    for(i = 0;i < V;i++){
                        if (e[i] == 0){
                            s = i;
                            visited.push(s);
                        }
                    }
                }
            }
            c = 0;
            if (l == V){
                flag = false;
            }
        }

        //Print the vertex in manner
        for (i = sorted.size() - 1;i >= 0;i--){
            System.out.print(sorted.get(i) + " -> ");
        }
    }
}
