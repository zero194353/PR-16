import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Game
{
    static void game(Stack<Integer> first, Stack<Integer> second)
    {
        int step = 0;

        while (!first.isEmpty() && !second.isEmpty() && step < 106)
        {
            step++;

            var t1 = first.pop();
            var t2 = second.pop();

            if (t1 > t2)
            {
                second.push(t1);
                second.push(t2);
            }
            else if (t1 < t2)
            {
                first.push(t1);
                first.push(t2);
            }
            else
            {
                first.push(t1);
                second.push(t2);
            }
        }

        if (first.isEmpty()) System.out.println("second " + step);
        else if (second.isEmpty()) System.out.println("first " + step);
        else System.out.println("botva");
    }

    public static void main(String[] args) throws Exception
    {
        var first  = new Stack<Integer>();
        var second = new Stack<Integer>();

        var reader = new BufferedReader(new InputStreamReader(System.in));

        // Ввод данных для 1ого игрока

        var input = reader.readLine();
        var splited = input.split(" ");

        for (var t : splited)
        {
            first.push(Integer.parseInt(t));
        }

        // Ввод данных для 2ого игрока

        input = reader.readLine();
        splited = input.split(" ");

        for (var t : splited)
        {
            second.push(Integer.parseInt(t));
        }

        // Собственно сама реализация игры

        game(first, second);
        main(args);
    }
}

