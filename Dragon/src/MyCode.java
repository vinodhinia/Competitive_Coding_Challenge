class MyCode {
	
//	https://codepad.remoteinterview.io/ZIQKBENUBG
   public static int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
   
    //init dp table
    int[][] h = new int[m][n];
   
    h[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
   
    //init last row
    for (int i = m - 2; i >= 0; i--) {
      h[i][n - 1] = Math.max(h[i + 1][n - 1] - dungeon[i][n - 1], 1);
    }
   
    //init last column
    for (int j = n - 2; j >= 0; j--) {
      h[m - 1][j] = Math.max(h[m - 1][j + 1] - dungeon[m - 1][j], 1);
    }
   
    //calculate dp table
    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        int down = Math.max(h[i + 1][j] - dungeon[i][j], 1);
        int right = Math.max(h[i][j + 1] - dungeon[i][j], 1);
        h[i][j] = Math.min(right, down);
      }
    }
   
    return h[0][0]+1;
  }
   
//   
//   function escape(dungeon) {
//	   //{{{
//	   const yBound = dungeon.length;
//	   const xBound = dungeon[0].length;
//
//	     // bottom right corner
//	   dungeon[yBound-1][xBound-1] = Math.max(1 - dungeon[yBound-1][xBound-1], 1);
//
//	   // bottom row
//	   for (let x = xBound - 2; x > -1; x--) {
//	     dungeon[yBound-1][x] = Math.max(dungeon[yBound-1][x+1] - dungeon[yBound-1][x], 1)
//	   }
//
//	   // right column
//	   for (let y = yBound - 2; y > -1; y--) {
//	     dungeon[y][xBound-1] = Math.max(dungeon[y+1][xBound-1] - dungeon[y][xBound-1], 1);
//	   }
//
//	   // remainder of dungeon
//	   for (let y = yBound - 2; y > -1; y--) {
//	     for (let x = xBound - 2; x > -1; x--) {
//	       let fromRight = Math.max(dungeon[y][x+1] - dungeon[y][x], 1);
//	       let fromBelow = Math.max(dungeon[y+1][x] - dungeon[y][x], 1);
//	       dungeon[y][x] = Math.min(fromRight, fromBelow);
//	     }
//	   }
//
//	   return dungeon[0][0];
//	   
//	 };
//
//	 let dungeon = [[ -2, -5, 10],
//	               [ -3,-10, 30],
//	               [  3,  5, 6]]


//	 console.log(escape(dungeon))
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
  int[][] dun = {{-2,-3,10},{-3,-10,30},{3,1,-5}};
   System.out.println(calculateMinimumHP(dun));
  }
}