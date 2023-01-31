package org.example.sort;

/**
 * @author NNPhong
 * @since 1/29/2023
 */
public class sort {

    public static void main(String[] args) {
        sort ob = new sort();
        int[] arr = {64, 25, 12, 22, 11};
        ob.selectionSort(arr);
        System.out.println("selectionSort array");
        ob.printArray(arr);

        ob.bubbleSort(arr);
        System.out.println("bubbleSort array");
        ob.printArray(arr);

        ob.insertionSort(arr);
        System.out.println("insertionSort array");
        ob.printArray(arr);

        ob.quickSort(arr, 0, arr.length - 1);
        System.out.println("quickSort array");
        ob.printArray(arr);

        ob.mergeSort(arr, 0, arr.length - 1);
        System.out.println("mergeSort array");
        ob.printArray(arr);
    }

    void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /**
     * merge sort
     **/
    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /**
     * merge sort
     **/

    /**
     * quick sort
     **/
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * quick sort
     **/

    /**
     * counting sort
     **/

    static int largest(int[] arr) {
        int i;
        int max = arr[0];
        for (i = 1; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];

        return max;
    }

    void countingSort(int[] arr) {
        int[] arrCount = new int[largest(arr) + 1];
        for (int j : arr) {
            ++arrCount[arr[j]];
        }
        int index = 0;
        for (int i = 0; i < arrCount.length; i++) {
            while (arrCount[i] > 0) {
                arr[index] = i;
                arrCount[i]--;
                index++;
            }
        }
    }

    /**
     * counting sort
     **/
}
