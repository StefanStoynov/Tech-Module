using System;

namespace _2._CircleArea
{
    class Program
    {
        static void Main(string[] args)
        {
            double radius = double.Parse(Console.ReadLine());
            double circleArea = Math.PI * radius* radius;
            Console.WriteLine("{0:f12}",circleArea);
        }
    }
}
