using System;

namespace Triples_of_Latin_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            n = (char)('a' + n);
            for (char i = 'a'; i < n; i++)
            {
                for (char j = 'a'; j < n; j++)
                {
                    for (char z = 'a'; z < n; z++)
                    {
                        Console.WriteLine("{0}{1}{2}",i,j,z);
                    }
                }

            }
        }
    }
}
