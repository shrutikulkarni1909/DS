import mpi.*;
public class ArraySumMPI {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MPI.Init(args);
		
		int rank=MPI.COMM_WORLD.Rank();
		int size=MPI.COMM_WORLD.Size();
		
		int[] array=new int[] {1,2,3,4,5,6,7,8};
		int N=8;
		int elementsPerProcess=N/size;
		int[] subArray=new int[elementsPerProcess];
		
		if(rank==0) {
			System.out.println("Original Array: ");
			for(int i=0;i<N;i++) {
				System.out.print(array[i]);
			}
			System.out.println();
		}
		
		int localSum=0;
		MPI.COMM_WORLD.Scatter(array,0,elementsPerProcess,MPI.INT,subArray,0,elementsPerProcess,MPI.INT,0);
		for(int i=0;i<elementsPerProcess;i++) {
			localSum+=subArray[i];
		}
		System.out.println("Processor "+rank+" Local Sum: "+localSum);
		
		int[] gatheredSum=new int[size];
		int totalSum=0;
		MPI.COMM_WORLD.Gather(new int[] {localSum},0,1,MPI.INT,gatheredSum,0,1,MPI.INT,0);
		if(rank==0) {
			System.out.println("Gathered Sum: ");
			for(int i=0;i<size;i++) {
				System.out.println("Processor "+i+" Sum= "+gatheredSum[i]);
				totalSum+=gatheredSum[i];
			}
			System.out.println("Total sum= "+totalSum);
		}
		MPI.Finalize();

	}

}
