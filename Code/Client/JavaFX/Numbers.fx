import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

var numbers : Integer [1..5]; //così definiamo il tipo di una variabile generica
//[1..5] crea un alista contenente interi da 1 a 5
//attr1: bind numbers;
insert 6 after numbers [100] //insrisce 6 in coda alla sequenza
insert 0 before numbers [-2] //inserisce 0 in testa
Stage {
    title: "Numbers!"
    width: 250
    height 80
    scene: {
        content: [
            Text {
                font : Font {size : 16 }
                x:10
                y:30
                content: bind "Numbers: {numbers}"
            }
        ]
    }
}