import com.example.springsnakes.entities.Move;
import com.example.springsnakes.entities.GameState;

@org.springframework.stereotype.Service
public class Service {
    public Move computeBestMove(GameState gameState) {
        return Move.down;
    }
}
