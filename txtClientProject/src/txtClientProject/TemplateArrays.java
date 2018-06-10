package txtClientProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TemplateArrays {
	
	private static Map<Integer, Integer[][]> templates = new HashMap<Integer, Integer[][]>();
	
	
	public static void initializeTemplates(){
		Integer[][] template4 = {  { 9, 2, 11, 14 }, // The number after template is how many groups there are each day
			    { 1, 4, 7, 12 },
			    { 5, 8, 15, 10 },
			    { 13, 3, 0, 6  },
			   { 3, 14, 12, 15 },
			    { 7, 8, 0, 9 },
			    { 6, 10, 4, 11 },
			    { 1, 13, 5, 2  },
			   { 15, 9, 6, 1 },
			    { 4, 13, 14, 8 },
			    { 12, 5, 0, 11 },
			    { 7, 2, 10, 3  },
			   { 2, 6, 8, 12 },
			    { 7, 15, 13, 11 },
			    { 3, 5, 9, 4 },
			    { 1, 14, 0, 10  },
			   { 9, 12, 10, 13 },
			    { 7, 14, 6, 5 },
			    { 0, 4, 2, 15 },
			    { 1, 8, 3, 11 }  };
		Integer[][] template5 = {  { 11, 6, 13, 3 },
			    { 17, 14, 15, 16 },
			    { 0, 18, 19, 5 },
			    { 10, 2, 12, 9 },
			    { 1, 4, 7, 8 } ,
			   { 15, 10, 1, 13 },
			    { 5, 12, 3, 4 },
			    { 17, 19, 2, 8 },
			    { 6, 16, 0, 9 },
			    { 7, 11, 18, 14 } ,
			   { 4, 9, 13, 19 },
			    { 16, 5, 11, 2 },
			    { 14, 8, 10, 3 },
			    { 0, 7, 12, 15 },
			    { 1, 17, 18, 6 } ,
			   { 14, 13, 0, 2 },
			    { 18, 4, 16, 10 },
			    { 6, 8, 5, 15 },
			    { 3, 7, 17, 9 },
			    { 11, 12, 1, 19 } ,
			   { 4, 0, 11, 17 },
			    { 1, 5, 14, 9 },
			    { 3, 2, 18, 15 },
			    { 10, 6, 19, 7 },
			    { 13, 16, 12, 8 }  };
		Integer[][] template6 = {  { 23, 3, 4, 8 },
			    { 21, 7, 6, 2 },
			    { 5, 13, 9, 1 },
			    { 22, 0, 19, 16 },
			    { 14, 15, 12, 11 },
			    { 10, 18, 17, 20 } ,
			   { 14, 1, 21, 10 },
			    { 23, 0, 11, 6 },
			    { 5, 22, 4, 2 },
			    { 8, 12, 19, 18 },
			    { 17, 15, 16, 9 },
			    { 13, 7, 20, 3 } ,
			   { 15, 4, 7, 18 },
			    { 17, 22, 1, 3 },
			    { 11, 20, 2, 16 },
			    { 23, 19, 9, 21 },
			    { 13, 12, 10, 6 },
			    { 5, 0, 14, 8 } ,
			   { 15, 2, 13, 8 },
			    { 20, 12, 1, 23 },
			    { 16, 6, 4, 14 },
			    { 21, 3, 18, 0 },
			    { 11, 10, 9, 22 },
			    { 7, 17, 5, 19 } ,
			   { 9, 12, 4, 0 },
			    { 7, 1, 16, 8 },
			    { 5, 6, 15, 20 },
			    { 3, 10, 2, 19 },
			    { 18, 14, 23, 22 },
			    { 17, 13, 11, 21 }  };
		Integer[][] template7 = { { 12, 27, 8, 20 },
			    { 7, 17, 3, 24 },
			    { 5, 23, 10, 16 },
			    { 6, 21, 11, 26 },
			    { 18, 19, 22, 25 },
			    { 14, 15, 9, 13 },
			    { 4, 2, 0, 1  },
			   { 9, 21, 22, 27 },
			    { 1, 24, 6, 25 },
			    { 15, 17, 4, 23 },
			    { 18, 20, 2, 26 },
			    { 8, 19, 16, 3 },
			    { 11, 5, 12, 14 },
			    { 7, 13, 0, 10  },
			   { 8, 9, 6, 7 },
			    { 4, 5, 26, 27 },
			    { 24, 14, 22, 23 },
			    { 20, 11, 13, 3 },
			    { 17, 18, 16, 0 },
			    { 2, 25, 12, 15 },
			    { 1, 10, 19, 21  },
			   { 9, 20, 10, 24 },
			    { 7, 1, 16, 26 },
			    { 14, 21, 4, 25 },
			    { 19, 23, 2, 27 },
			    { 15, 3, 5, 18 },
			    { 13, 17, 12, 6 },
			    { 8, 11, 0, 22  },
			   { 13, 24, 8, 2 },
			    { 14, 18, 6, 27 },
			    { 5, 20, 1, 22 },
			    { 3, 21, 0, 23 },
			    { 15, 11, 7, 19 },
			    { 9, 16, 12, 4 },
			    { 10, 26, 25, 17  } };
		Integer[][] template8 = {  { 17, 3, 8, 30 },
			    { 1, 26, 6, 28 },
			    { 5, 27, 14, 29 },
			    { 10, 25, 12, 20 },
			    { 21, 22, 2, 24 },
			    { 18, 19, 16, 9 },
			    { 4, 15, 23, 13 },
			    { 31, 11, 0, 7  },
			   { 9, 30, 13, 31 },
			    { 7, 26, 18, 29 },
			    { 21, 28, 4, 27 },
			    { 3, 24, 16, 10 },
			    { 20, 0, 2, 5 },
			    { 17, 19, 23, 6 },
			    { 8, 15, 12, 14 },
			    { 1, 11, 22, 25  },
			   { 8, 9, 6, 7 },
			    { 4, 29, 30, 2 },
			    { 3, 23, 28, 5 },
			    { 26, 0, 24, 25 },
			    { 20, 15, 31, 22 },
			    { 17, 12, 16, 11 },
			    { 13, 14, 18, 21 },
			    { 1, 10, 27, 19  },
			   { 13, 16, 8, 28 },
			    { 24, 31, 6, 18 },
			    { 14, 3, 4, 7 },
			    { 25, 27, 23, 2 },
			    { 26, 19, 30, 22 },
			    { 17, 21, 29, 20 },
			    { 11, 15, 10, 5 },
			    { 1, 9, 0, 12  },
			   { 9, 28, 22, 29 },
			    { 7, 30, 1, 23 },
			    { 5, 24, 4, 17 },
			    { 3, 26, 31, 12 },
			    { 2, 18, 10, 8 },
			    { 25, 15, 16, 21 },
			    { 11, 14, 19, 20 },
			    { 6, 27, 0, 13 }  };
		Integer[][] template9 = {  { 12, 23, 8, 34 },
			    { 2, 25, 6, 32 },
			    { 5, 31, 4, 17 },
			    { 10, 14, 27, 28 },
			    { 33, 26, 35, 24 },
			    { 21, 22, 7, 20 },
			    { 0, 19, 16, 30 },
			    { 29, 15, 9, 13 },
			    { 3, 11, 18, 1  },
			   { 10, 20, 8, 35 },
			    { 7, 28, 15, 33 },
			    { 1, 30, 4, 12 },
			    { 3, 32, 27, 29 },
			    { 19, 26, 23, 25 },
			    { 34, 17, 2, 21 },
			    { 22, 24, 16, 18 },
			    { 13, 6, 31, 14 },
			    { 5, 11, 0, 9  },
			   { 8, 9, 3, 7 },
			    { 18, 5, 34, 35 },
			    { 32, 33, 30, 31 },
			    { 6, 17, 23, 10 },
			    { 24, 25, 28, 13 },
			    { 20, 19, 2, 11 },
			    { 27, 4, 16, 21 },
			    { 26, 14, 12, 15 },
			    { 1, 29, 0, 22  },
			   { 29, 33, 8, 17 },
			    { 7, 35, 6, 30 },
			    { 18, 9, 4, 28 },
			    { 3, 31, 24, 34 },
			    { 22, 11, 14, 25 },
			    { 0, 27, 2, 23 },
			    { 15, 19, 21, 10 },
			    { 13, 32, 12, 16 },
			    { 5, 26, 20, 1  },
			   { 21, 32, 8, 1 },
			    { 15, 34, 6, 16 },
			    { 5, 28, 2, 29 },
			    { 17, 30, 27, 25 },
			    { 22, 31, 9, 26 },
			    { 20, 23, 4, 24 },
			    { 7, 18, 14, 19 },
			    { 13, 35, 0, 3 },
			    { 10, 11, 12, 33 }  };
		Integer[][] template10 = {  { 18, 28, 8, 38 },
			    { 10, 20, 6, 36 },
			    { 5, 35, 4, 34 },
			    { 32, 25, 30, 14 },
			    { 22, 29, 27, 39 },
			    { 33, 26, 23, 12 },
			    { 21, 3, 2, 37 },
			    { 9, 19, 0, 17 },
			    { 31, 15, 24, 13 },
			    { 7, 11, 16, 1  },
			   { 9, 38, 2, 39 },
			    { 7, 36, 29, 37 },
			    { 5, 25, 28, 15 },
			    { 11, 33, 30, 19 },
			    { 3, 4, 27, 6 },
			    { 24, 26, 20, 34 },
			    { 23, 22, 8, 21 },
			    { 13, 32, 16, 18 },
			    { 17, 35, 12, 14 },
			    { 1, 31, 0, 10  },
			   { 8, 9, 6, 13 },
			    { 1, 5, 37, 39 },
			    { 36, 38, 34, 27 },
			    { 31, 32, 28, 33 },
			    { 3, 17, 30, 29 },
			    { 24, 25, 23, 10 },
			    { 20, 14, 2, 22 },
			    { 35, 15, 16, 19 },
			    { 7, 21, 12, 18 },
			    { 4, 26, 0, 11  },
			   { 9, 16, 30, 36 },
			    { 32, 39, 6, 15 },
			    { 22, 33, 4, 7 },
			    { 31, 25, 8, 34 },
			    { 3, 26, 35, 10 },
			    { 24, 0, 21, 27 },
			    { 2, 19, 18, 5 },
			    { 17, 23, 37, 20 },
			    { 11, 38, 29, 14 },
			    { 1, 13, 28, 12  },
			   { 24, 36, 8, 14 },
			    { 7, 38, 6, 26 },
			    { 5, 16, 20, 33 },
			    { 31, 18, 30, 35 },
			    { 3, 25, 39, 12 },
			    { 9, 27, 23, 28 },
			    { 1, 34, 19, 22 },
			    { 17, 4, 32, 21 },
			    { 11, 37, 10, 15 },
			    { 2, 29, 0, 13 }  };
		Integer[][] template11 = {  { 35, 3, 8, 42 },
			    { 27, 41, 6, 33 },
			    { 5, 39, 13, 38 },
			    { 11, 37, 17, 9 },
			    { 32, 40, 12, 31 },
			    { 43, 29, 7, 28 },
			    { 25, 26, 23, 0 },
			    { 21, 22, 16, 20 },
			    { 18, 19, 2, 34 },
			    { 14, 15, 30, 4 },
			    { 10, 36, 24, 1  },
			   { 31, 20, 8, 43 },
			    { 7, 40, 13, 36 },
			    { 3, 38, 4, 26 },
			    { 35, 37, 34, 41 },
			    { 9, 10, 30, 32 },
			    { 5, 11, 27, 29 },
			    { 24, 39, 18, 25 },
			    { 42, 22, 2, 14 },
			    { 17, 19, 16, 23 },
			    { 6, 15, 12, 21 },
			    { 1, 28, 0, 33  },
			   { 8, 34, 25, 7 },
			    { 42, 43, 40, 41 },
			    { 4, 0, 20, 39 },
			    { 35, 36, 9, 23 },
			    { 31, 19, 30, 33 },
			    { 3, 27, 28, 22 },
			    { 24, 6, 37, 26 },
			    { 38, 21, 2, 29 },
			    { 1, 18, 16, 32 },
			    { 13, 14, 12, 11 },
			    { 17, 10, 5, 15  },
			   { 9, 1, 8, 40 },
			    { 14, 43, 6, 5 },
			    { 42, 19, 4, 36 },
			    { 28, 39, 34, 21 },
			    { 3, 33, 29, 20 },
			    { 35, 12, 27, 30 },
			    { 22, 17, 38, 25 },
			    { 32, 24, 2, 23 },
			    { 15, 37, 7, 18 },
			    { 13, 26, 31, 16 },
			    { 10, 11, 0, 41  },
			   { 22, 18, 8, 41 },
			    { 7, 42, 6, 0 },
			    { 5, 31, 4, 37 },
			    { 35, 38, 16, 10 },
			    { 14, 32, 29, 25 },
			    { 28, 30, 2, 36 },
			    { 9, 33, 21, 26 },
			    { 20, 23, 27, 13 },
			    { 15, 40, 3, 19 },
			    { 24, 34, 12, 17 },
			    { 39, 11, 43, 1 }  };
		Integer[][] template12 = {  { 37, 47, 8, 18 },
			    { 3, 45, 6, 4 },
			    { 23, 43, 41, 36 },
			    { 44, 40, 38, 19 },
			    { 42, 21, 34, 35 },
			    { 32, 0, 30, 31 },
			    { 7, 29, 12, 28 },
			    { 25, 26, 5, 24 },
			    { 9, 10, 2, 20 },
			    { 46, 39, 16, 17 },
			    { 14, 15, 27, 13 },
			    { 22, 11, 33, 1  },
			   { 2, 46, 8, 38 },
			    { 7, 44, 6, 41 },
			    { 5, 42, 20, 15 },
			    { 4, 39, 47, 40 },
			    { 11, 24, 34, 36 },
			    { 27, 33, 30, 17 },
			    { 3, 28, 31, 10 },
			    { 37, 14, 23, 25 },
			    { 45, 22, 9, 21 },
			    { 32, 19, 16, 18 },
			    { 13, 43, 12, 26 },
			    { 1, 35, 0, 29  },
			   { 8, 9, 6, 28 },
			    { 5, 41, 46, 30 },
			    { 44, 45, 42, 43 },
			    { 4, 38, 1, 16 },
			    { 35, 13, 19, 37 },
			    { 31, 29, 25, 33 },
			    { 3, 27, 7, 32 },
			    { 20, 47, 23, 26 },
			    { 24, 21, 2, 15 },
			    { 17, 18, 40, 34 },
			    { 36, 14, 12, 22 },
			    { 39, 10, 0, 11  },
			   { 9, 11, 31, 44 },
			    { 7, 47, 1, 46 },
			    { 5, 28, 4, 43 },
			    { 39, 42, 38, 29 },
			    { 33, 37, 32, 21 },
			    { 8, 15, 30, 34 },
			    { 3, 26, 19, 41 },
			    { 24, 40, 23, 27 },
			    { 2, 25, 18, 22 },
			    { 13, 36, 16, 20 },
			    { 45, 35, 10, 14 },
			    { 6, 17, 0, 12  },
			   { 24, 31, 8, 45 },
			    { 43, 46, 6, 37 },
			    { 5, 2, 40, 7 },
			    { 4, 42, 33, 36 },
			    { 32, 47, 44, 34 },
			    { 30, 35, 3, 25 },
			    { 26, 29, 9, 27 },
			    { 23, 28, 39, 18 },
			    { 19, 22, 17, 20 },
			    { 16, 21, 11, 14 },
			    { 10, 15, 1, 12 },
			    { 0, 13, 38, 41 }  };
		Integer[][] template13 = {  { 30, 51, 8, 23 },
			    { 7, 49, 1, 41 },
			    { 12, 47, 45, 46 },
			    { 43, 16, 48, 42 },
			    { 33, 28, 38, 39 },
			    { 36, 2, 3, 35 },
			    { 32, 4, 9, 31 },
			    { 34, 29, 0, 40 },
			    { 19, 26, 50, 24 },
			    { 21, 22, 37, 20 },
			    { 18, 25, 44, 17 },
			    { 14, 15, 5, 13 },
			    { 10, 11, 27, 6  },
			   { 9, 50, 23, 3 },
			    { 7, 48, 6, 13 },
			    { 5, 46, 38, 20 },
			    { 42, 44, 41, 26 },
			    { 4, 39, 45, 40 },
			    { 18, 1, 34, 36 },
			    { 15, 33, 10, 43 },
			    { 51, 21, 27, 29 },
			    { 24, 32, 8, 25 },
			    { 47, 22, 2, 28 },
			    { 17, 19, 16, 35 },
			    { 49, 31, 12, 14 },
			    { 37, 11, 0, 30  },
			   { 8, 9, 6, 20 },
			    { 50, 51, 5, 45 },
			    { 48, 49, 17, 47 },
			    { 24, 43, 41, 22 },
			    { 1, 38, 19, 40 },
			    { 35, 31, 13, 37 },
			    { 36, 32, 30, 33 },
			    { 3, 26, 28, 29 },
			    { 42, 25, 23, 27 },
			    { 7, 21, 2, 44 },
			    { 46, 18, 16, 39 },
			    { 34, 11, 12, 15 },
			    { 4, 10, 0, 14  },
			   { 9, 40, 25, 48 },
			    { 18, 51, 6, 41 },
			    { 5, 44, 43, 32 },
			    { 42, 46, 50, 31 },
			    { 4, 13, 36, 49 },
			    { 35, 39, 34, 21 },
			    { 23, 33, 29, 47 },
			    { 28, 45, 15, 30 },
			    { 22, 26, 38, 8 },
			    { 20, 24, 0, 3 },
			    { 27, 19, 14, 7 },
			    { 37, 17, 12, 10 },
			    { 16, 11, 2, 1  },
			   { 9, 39, 43, 49 },
			    { 7, 50, 10, 34 },
			    { 4, 8, 44, 47 },
			    { 14, 29, 41, 20 },
			    { 5, 36, 37, 40 },
			    { 35, 38, 51, 48 },
			    { 3, 32, 45, 17 },
			    { 26, 30, 27, 31 },
			    { 11, 25, 21, 28 },
			    { 46, 23, 2, 24 },
			    { 15, 18, 42, 19 },
			    { 13, 16, 12, 33 },
			    { 6, 22, 0, 1 }  };
		Integer[][] template14 = {  { 9, 26, 43, 54 },
			    { 7, 39, 31, 52 },
			    { 50, 51, 33, 24 },
			    { 47, 36, 45, 0 },
			    { 8, 44, 41, 29 },
			    { 15, 40, 38, 53 },
			    { 48, 37, 34, 35 },
			    { 32, 5, 30, 6 },
			    { 3, 42, 22, 28 },
			    { 25, 55, 23, 49 },
			    { 21, 27, 14, 20 },
			    { 10, 19, 16, 17 },
			    { 2, 4, 12, 13 },
			    { 18, 11, 46, 1  },
			   { 48, 39, 8, 55 },
			    { 7, 1, 35, 53 },
			    { 14, 51, 49, 28 },
			    { 46, 9, 17, 47 },
			    { 42, 44, 20, 43 },
			    { 4, 54, 38, 19 },
			    { 6, 13, 34, 36 },
			    { 31, 33, 23, 32 },
			    { 3, 50, 27, 29 },
			    { 24, 2, 30, 25 },
			    { 41, 22, 26, 21 },
			    { 45, 40, 16, 18 },
			    { 37, 15, 12, 5 },
			    { 52, 11, 0, 10  },
			   { 0, 9, 6, 7 },
			    { 41, 55, 52, 53 },
			    { 5, 50, 49, 16 },
			    { 43, 25, 45, 48 },
			    { 42, 46, 54, 12 },
			    { 4, 3, 39, 40 },
			    { 27, 36, 11, 37 },
			    { 19, 21, 30, 33 },
			    { 38, 35, 28, 29 },
			    { 24, 47, 23, 26 },
			    { 20, 32, 2, 22 },
			    { 17, 18, 51, 31 },
			    { 13, 14, 44, 15 },
			    { 1, 10, 8, 34  },
			   { 9, 53, 21, 37 },
			    { 44, 55, 6, 54 },
			    { 5, 48, 42, 11 },
			    { 46, 50, 45, 34 },
			    { 40, 7, 30, 43 },
			    { 39, 47, 38, 41 },
			    { 3, 52, 32, 36 },
			    { 31, 35, 4, 49 },
			    { 33, 26, 14, 29 },
			    { 2, 28, 23, 27 },
			    { 24, 19, 18, 22 },
			    { 17, 8, 12, 20 },
			    { 51, 15, 10, 25 },
			    { 1, 13, 0, 16  },
			   { 9, 52, 8, 5 },
			    { 7, 21, 50, 55 },
			    { 53, 47, 48, 51 },
			    { 46, 49, 27, 6 },
			    { 37, 22, 4, 44 },
			    { 14, 41, 35, 42 },
			    { 33, 36, 10, 40 },
			    { 31, 34, 30, 38 },
			    { 3, 25, 26, 17 },
			    { 24, 45, 13, 28 },
			    { 2, 1, 19, 43 },
			    { 29, 20, 16, 54 },
			    { 11, 39, 32, 15 },
			    { 18, 12, 0, 23 }  };
		templates.put(4, template4);
		templates.put(5, template5);
		templates.put(6, template6);
		templates.put(7, template7);
		templates.put(8, template8);
		templates.put(9, template9);
		templates.put(10, template10);
		templates.put(11, template11);
		templates.put(12, template12);
		templates.put(13, template13);
		templates.put(14, template14);
	}
	
	public static Integer[][] selectTemplate(int numGroups){
		//System.out.println(Arrays.deepToString(templates.get(numGroups)));
		return templates.get(numGroups);
	}

}
