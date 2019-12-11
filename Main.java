
public class Main {

    private String text ="Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
            "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
            "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
            "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. \n" +
            "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. \n" +
            "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";
    private char[] symbols= text.toCharArray();
    private String[] symbolsInString = new String[symbols.length];
    private StringBuilder decodedText = new StringBuilder();
    private String[] alphabet={"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я"};


    public static void main(String[] args) {
        Main main = new Main() ;
        main.startDecoding();
    }

    private void startDecoding() {

        String regExp = "[абвгдеёжзийклмнопрстуфхцчшщыъьэюя]";
        for (int i = 0; i < symbols.length; i++){
            symbolsInString[i]=String.valueOf(symbols[i]).toLowerCase();
        }

        int positionInAlphabet=0;
        final int SHIFT = 10;

        for (int i=0;i<symbolsInString.length;i++){

                for (int j=0;j<alphabet.length;j++){

                    if (symbolsInString[i].equals(alphabet[j])){
                        positionInAlphabet=j+1;
                    }
                }

            int shiftPosition = positionInAlphabet+SHIFT;

            if (shiftPosition>=alphabet.length){
                shiftPosition=shiftPosition-alphabet.length;
            }
            if(symbolsInString[i].matches(regExp)){
                decodedText.append(alphabet[shiftPosition]);

            }else if(symbolsInString[i].equals(",")){
                decodedText.append(",");

            }else if(symbolsInString[i].equals(".")) {
                decodedText.append(".");

            }else{
                decodedText.append(" ");
            }

        }

        System.out.println(decodedText.toString().toUpperCase());
    }
}
