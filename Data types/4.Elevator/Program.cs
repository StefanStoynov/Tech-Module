using System;

namespace Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            int people = int.Parse(Console.ReadLine());
            int capacity = int.Parse(Console.ReadLine());

            int reounds = 0;

            if (people % capacity == 0)
            {
                reounds = people / capacity;
            }
            else
            {
                reounds = (people / capacity) + 1;
            }
            Console.WriteLine(reounds);
        }
    }
}
