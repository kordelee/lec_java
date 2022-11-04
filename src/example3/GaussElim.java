package example3;

import java.io.PrintWriter;

public class GaussElim {
	public static void elimination(int size,double[] pF,double[] pG,double[] pX){
		int i,j,k,row,numeqs=size;
		
		double [][] augmnt = new double[14][15];	
		double temp,pivot,factor;
		
		for(i=0;i<numeqs;i++)
		{
			System.out.println("");
			for(j=0;j<numeqs;j++)
			{
			
				augmnt[i][j]=pF[i*numeqs+j];
				System.out.printf("%12.3f", augmnt[i][j]);

			}
		}
		System.out.println("");

		for(i=0;i<numeqs;i++)
		{
			System.out.println("");
			for(j=0;j<1;j++)
			{
				
				augmnt[i][numeqs]=pG[i+j];
				System.out.printf("%12.3f", augmnt[i][numeqs]);

			}
		}
		System.out.println("");

		for(i=0;i<numeqs;i++)
		{
			System.out.println("");
			for(j=0;j<numeqs+1;j++)
			{
				System.out.printf("%12.3f", augmnt[i][j]);
			}
		}
		System.out.println("");


		for(i=0;i<numeqs;i++)
		{
			pivot=augmnt[i][i];
			row=i+1;

			if(pivot==0.0)
			{
				while(pivot==0.0 && row<=numeqs)
				{
					if(augmnt[row][i] !=0)
						pivot=augmnt[row][i];
					else
						row++;
				}

				if(pivot==0.0)
				{
					System.out.println("A unique solution does not exist for these equations");
					return;
				}
				else
				{
					for(j=0;j<numeqs+1;j++){
						temp=augmnt[i][j];
						augmnt[i][j]=augmnt[row][j];
						augmnt[row][j]=temp;
					}
				}
			}

			pivot=augmnt[i][i];
			for(j=i;j<numeqs+1;j++)
				augmnt[i][j]=augmnt[i][j]/pivot;

			for(k=0;k<numeqs;k++)
			{
				factor=-augmnt[k][i];
				if(k!=i)
				{
					for(j=i;j<numeqs+1;j++)
						augmnt[k][j]=augmnt[k][j]+factor*augmnt[i][j];
				}
			}
		}

		System.out.println("");
		System.out.println("The solution is: ");
		System.out.println("");
		
		for(i=0;i<numeqs;i++)
		{
			pX[i]=augmnt[i][numeqs];
			System.out.printf("x%d: %12.3f\n", (i+1), pX[i]);
		}

	}
	
public static void main(String[] args) {
		try {
//			PrintWriter file=new PrintWriter("E:/java_study/java_day1/phi1.txt");
			PrintWriter file=new PrintWriter("D:/factory/ws_sts4_4130/lec_java/src/example3/phi1.txt");

			int i, j, k;
			int iter = 0, size = 5, size2 = 3;
			double PHI = 3.14;
			double L1 = 500, g = 9810, phi1 = -PHI / 4.0;
			double m = 7.7067;
			double dt = 0.01;
			double x1 = L1 / 2.0*Math.cos(phi1);
			double y1 = L1 / 2.0*Math.sin(phi1);

			double [] q_dot = new double[10];
			double [] Q_A = { 0, -m*g, 0 };
			double [] q = { x1, y1, phi1, 0, 0 };
			double [] X = { q[2], q_dot[2] };
			double [][] X_dot = new double[2][501];
			double [][] U = new double[2][501];
			double [] gamma = new double[2];
			double [][] M = new double[3][3];
			double [][] Phi_q = new double[3][3];
			double [][] F = new double[5][5];
			double [] Phi = new double[3];
			double [] dq = { 0, 0, 0 };
			double [] Phi_t = { 0, 0, 0 };
			double [] G = new double[5];
			double [] q_doubledot = new double[5];
			double [] FL = new double[25];
			double [] Phi_qL = new double[9];
			
			
			for (k = 0; k<500; k++)
			{

				gamma[0] = q_dot[2] * q_dot[2] * L1 / 2 * Math.cos(phi1);
				gamma[1] = q_dot[2] * q_dot[2] * L1 / 2 * Math.sin(phi1);
				M[0][0] = m;
				M[0][1] = 0;
				M[0][2] = 0;
				M[1][0] = 0;
				M[1][1] = m;
				M[1][2] = 0;
				M[2][0] = 0;
				M[2][1] = 0;
				M[2][2] = 1 / 12.0*m*Math.pow(500.0, 2);
				Phi_q[0][0] = -1;
				Phi_q[0][1] = 0;
				Phi_q[0][2] = -L1 / 2.0*Math.sin(phi1);
				Phi_q[1][0] = 0;
				Phi_q[1][1] = -1;
				Phi_q[1][2] = L1 / 2.0*Math.cos(phi1);
				F[0][0] = M[0][0];
				F[0][1] = M[0][1];
				F[0][2] = M[0][2];
				F[0][3] = Phi_q[0][0];
				F[0][4] = Phi_q[1][0];
				F[1][0] = M[1][0];
				F[1][1] = M[1][1];
				F[1][2] = M[1][2];
				F[1][3] = Phi_q[0][1];
				F[1][4] = Phi_q[1][1];
				F[2][0] = M[2][0];
				F[2][1] = M[2][1];
				F[2][2] = M[2][2];
				F[2][3] = Phi_q[0][2];
				F[2][4] = Phi_q[1][2];
				F[3][0] = Phi_q[0][0];
				F[3][1] = Phi_q[0][1];
				F[3][2] = Phi_q[0][2];
				F[3][3] = 0;
				F[3][4] = 0;
				F[4][0] = Phi_q[1][0];
				F[4][1] = Phi_q[1][1];
				F[4][2] = Phi_q[1][2];
				F[4][3] = 0;
				F[4][4] = 0;
				G[0] = Q_A[0];
				G[1] = Q_A[1];
				G[2] = Q_A[2];
				G[3] = gamma[0];
				G[4] = gamma[1];


				for (i = 0; i<size; i++)
				{
					for (j = 0; j<size; j++)
					{
						FL[i*size + j] = F[i][j];
					}
				}
				
				elimination(size, FL, G, q_doubledot);  // 객체 생성없이 출력
				
				X_dot[0][k + 1] = q_dot[2];
				X_dot[1][k + 1] = q_doubledot[2];

				U[0][k] = (-X_dot[0][k] + 3 * X_dot[0][k + 1]) / 2.0;
				U[1][k] = (-X_dot[1][k] + 3 * X_dot[1][k + 1]) / 2.0;

				X[0] = X[0] + dt*U[0][k];
				X[1] = X[1] + dt*U[1][k];

				phi1 = X[0];
				iter = 0;
				file.printf("%12.3f\n", phi1);
				
				while (true)
				{
					q[0] = x1;
					q[1] = y1;
					q[2] = phi1;

					Phi[0] = -x1 + L1 / 2.0*Math.cos(phi1);
					Phi[1] = -y1 + L1 / 2.0*Math.sin(phi1);
					Phi[2] = 0;

					Phi_q[0][0] = -1 * (-1);
					Phi_q[0][1] = 0 * (-1);
					Phi_q[0][2] = -L1 / 2 * Math.sin(phi1)*(-1);
					Phi_q[1][0] = 0 * (-1);
					Phi_q[1][1] = -1 * (-1);
					Phi_q[1][2] = L1 / 2 * Math.cos(phi1)*(-1);
					Phi_q[2][0] = 0 * (-1);
					Phi_q[2][1] = 0 * (-1);
					Phi_q[2][2] = 1 * (-1);

					for (i = 0; i<size2; i++)
					{
						for (j = 0; j<size2; j++)
						{
							Phi_qL[i*size2 + j] = Phi_q[i][j];
						}
					}

					elimination(size2, Phi_qL, Phi, dq);

					q[0] = q[0] + dq[0];
					q[1] = q[1] + dq[1];
					q[2] = q[2] + dq[2];

					x1 = q[0];
					y1 = q[1];
					phi1 = q[2];

					iter = iter + 1;

					if ((Phi[0] * Phi[0] + Phi[1] * Phi[1] + Phi[2] * Phi[2]) <= Math.pow(10.0, -10) || iter >= 1000)
						break;
				}
				System.out.printf("%d\n", iter);
				
				q_dot[2] = X[1];

				Phi_t[0] = 0;
				Phi_t[1] = 0;
				Phi_t[2] = -X[1];

				elimination(size2, Phi_qL, Phi_t, q_dot);
			}
			file.close();
			
		} catch(Exception e) {
				System.out.println(e);
		}
	}
}
