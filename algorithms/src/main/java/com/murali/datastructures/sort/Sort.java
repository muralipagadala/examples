package com.murali.datastructures.sort;

import java.util.Arrays;
import java.util.Comparator;



public class Sort {

	/**
	 * Bubble sort approach 1
	 * @param array
	 * @return
	 */
	public int[] bubbleSort_1(int[] array){
		int size = array.length;
		while(size > 0){
			int i = 0;
			for(int j = 1; j < size; j++, i++){
				if(array[i] > array[j]){
					swap(array, i, j);
				}
			}
			--size;			
		}
		return array;
	}
	
	/**
	 * Bubble sort approach 2
	 * @param array
	 * @return
	 */
	public int[] bubbleSort_2(int[] array){
		int in, out;
		for(out = array.length-1; out > 0; out--){
			for(in = 0; in < out; in++){
				if(array[in] > array[in+1]){
					swap(array, in, in+1);
				}
			}
		}
		return array;
	}
	
	private void swap(int[] array, int i, int j){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	/**
	 * Selection sort algorithm.
	 * 
	 * @param array
	 * @return
	 */
	public int[] selectionSort(int[] array){
		for(int out = 0; out < array.length; out++){
			int index = out;
			for(int in = out + 1; in < array.length; in++){
				if(array[in] < array[index] ){
					index = in;
				}
			}
			swap(array, out, index);
		}
		return array;
	}
	
	public int[] insertionSort(int[] array){
		int in, out;
		for(out = 1; out < array.length; out++){
			int selectedValue = array[out];
			in = out;
			while(in > 0 && array[in-1] >= selectedValue){
				array[in] = array[in-1];
				--in;
			}
			array[in] = selectedValue;
		}
		System.out.println("After sorting :"+Arrays.toString(array));
		return array;
	}
	
	public Person[] insertionSort(Person[] persons){
		int in, out;
		for(out = 1; out < persons.length; out++){
			Person selectedPerson = persons[out];
			in = out;
			while(in > 0 &&
					persons[in-1].getLastName().compareTo(selectedPerson.getLastName()) > 0 ){
				persons[in] = persons[in-1];
				--in;
			}
			persons[in] = selectedPerson;
		}
		return persons;
	}
	
	public Person[] sortPersons(Person[] persons){
		Comparator personComparator = new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				Person p1 = (Person) o1;
				Person p2 = (Person) o2;
				return p1.getLastName().compareTo(p2.getLastName());
			}
		};
		
		Arrays.sort(persons, personComparator);
		return persons;
	}
}
