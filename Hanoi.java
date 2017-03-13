class Hanoi
{
  private int count;

  public static void main(String[] args)
  {
    count = 0;
    move(5, A, B, C);
    
  }

  public static void move(int disks, char from, char spare, char dest)
  {
    if (disks == 1)
    {
      System.out.println(from+"->"+dest);
    }

    else
    {
      move(disks-1, from, dest, spare);
      move(1, from, spare, dest);
      move(disks-1, spare, from, dest);
    }
  }
}
