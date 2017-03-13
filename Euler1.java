class Multiple
{
   public static void main(String[] args)
   {
      int max = 10;

      for (int i=0; i<max; i++)
      {
         if (i % 3 == 0 || i % 5 == 0)
         {
            sum += 1;
         }

         System.out.println(sum);
      }
   }
}  