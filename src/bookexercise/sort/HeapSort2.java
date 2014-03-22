package bookexercise.sort;

public class HeapSort2 {
  
  public static void main(String[] args) {
    Integer[] data = new Integer[10];
    int i;
    
    for (i = 9; i >= 0; --i) {
      data[i] = i;
    } // end for
    
    sort(data);
    
    for (i = 0; i <= 9; ++i) {
      System.out.printf("%d ", data[i]);
    } // end for
    
  } // main()

  public static int leftChild(int i) {
    return 2 * i + 1;
  } // end leftChld()
  
  public static <T extends Comparable<? super T>>
  void permDown(T[] data, int i, int length) {
    int child;
    T temp = data[i];
    
    for (; (child = leftChild(i)) < length; i = child) {
      if ((child + 1) < length && data[child].compareTo(data[child + 1]) < 0) {
        ++child;
      } // end if
      if (data[child].compareTo(temp) > 0) {
        data[i] = data[child];
      } // end if
      else {
        break;
      } // end else
    } // end for
    data[i] = temp;
  } // end permDown()

  public static <T extends Comparable<? super T>>
  void sort(T[] data) {
    int i, length;
    
    if (data == null || data.length == 0) {
      return ;
    } // end if
    
    length = data.length;
    for (i = length / 2; i >= 0; --i) {
      permDown(data, i, length);
    } // end for
    
    for (i = length - 1; i >= 0; --i) {
      swap(data, 0, i);
      permDown(data, 0, i);
    } // end for
    
  } // end sort()
  
  public static <T> void swap(T[] data, int i, int j) {
    T temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  } // end swap()
  
} // end class HeapSort