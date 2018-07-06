public class StringEncryption {
    private String formattedString, direction, coordDirection, encryptedString;
    private char[][] grid;
    private int encryptedStringLength, rowCoord, colCoord;

    public StringEncryption(String rawString, int col, int row, String direction){
        formattedString = formatRawString(rawString);
        grid = setGrid(row, col);
        this.direction = direction;
        encryptedStringLength = row * col;

        if(direction.equals("clockwise"))
            coordDirection = "down";
        else
            coordDirection = "left";

        calculateEncryptedString();
    }

    private String formatRawString(String rawString){
        String out = "";
        for(int i = 0; i < rawString.length(); i++)
            if(Character.isLetter(rawString.charAt(i)))
                out += rawString.charAt(i);

        return out.toUpperCase();
    }

    private char[][] setGrid(int rowCount, int colCount) {
        grid = new char[rowCount + 2][colCount + 2];
        int stringIndex = 0;

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++)
                if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1)
                    grid[row][col] = '\0';
                else if (stringIndex < formattedString.length()) {
                    grid[row][col] = formattedString.charAt(stringIndex);
                    stringIndex++;
                }
                else
                    grid[row][col] = 'X';

        return grid;
    }
    public void calculateEncryptedString(){
        encryptedString = "";
        rowCoord = 1;
        colCoord = grid[0].length - 2;

        while(encryptedString.length() != encryptedStringLength){
            encryptedString += grid[rowCoord][colCoord];
            grid[rowCoord][colCoord] = '\0';
            nextCharacter();
        }
    }

    public void nextCharacter(){

        if(direction.equals("clockwise")) {
            if (coordDirection.equals("down") && grid[rowCoord + 1][colCoord] == '\0') { //if the char below is null, move left and change direction left
                colCoord--;
                coordDirection = "left";
            }
            else if (coordDirection.equals("down") && grid[rowCoord + 1][colCoord] != '\0') //if the char below is not null, move down
                rowCoord++;

            else if (coordDirection.equals("left") && grid[rowCoord][colCoord - 1] == '\0') { //if the char left is null, move up and change direction up
                rowCoord--;
                coordDirection = "up";
            }
            else if (coordDirection.equals("left") && grid[rowCoord][colCoord - 1] != '\0') //if the char left isn't null, move left
                colCoord--;

            else if (coordDirection.equals("up") && grid[rowCoord - 1][colCoord] == '\0') { //if the char up is null, move right and change direction right
                colCoord++;
                coordDirection = "right";
            }
            else if (coordDirection.equals("up") && grid[rowCoord - 1][colCoord] != '\0') //if the char up isnt null, move up
                rowCoord--;

            else if (coordDirection.equals("right") && grid[rowCoord][colCoord + 1] == '\0') {
                rowCoord++;
                coordDirection = "down";
            }
            else if (coordDirection.equals("right") && grid[rowCoord][colCoord + 1] != '\0')
                colCoord++;
        }

        else{
            if (coordDirection.equals("down") && grid[rowCoord + 1][colCoord] == '\0') { //if the char below is null, move left and change direction left
                colCoord++;
                coordDirection = "right";
            }
            else if (coordDirection.equals("down") && grid[rowCoord + 1][colCoord] != '\0') //if the char below is not null, move down
                rowCoord++;

            else if (coordDirection.equals("left") && grid[rowCoord][colCoord - 1] == '\0') { //if the char left is null, move up and change direction up
                rowCoord++;
                coordDirection = "down";
            }
            else if (coordDirection.equals("left") && grid[rowCoord][colCoord - 1] != '\0') //if the char left isn't null, move left
                colCoord--;

            else if (coordDirection.equals("up") && grid[rowCoord - 1][colCoord] == '\0') { //if the char up is null, move right and change direction right
                colCoord--;
                coordDirection = "left";
            }
            else if (coordDirection.equals("up") && grid[rowCoord - 1][colCoord] != '\0') //if the char up isnt null, move up
                rowCoord--;

            else if (coordDirection.equals("right") && grid[rowCoord][colCoord + 1] == '\0') {
                rowCoord--;
                coordDirection = "up";
            }
            else if (coordDirection.equals("right") && grid[rowCoord][colCoord + 1] != '\0')
                colCoord++;
        }
    }

    public String getEncryptedString() {
        return encryptedString;
    }
}
