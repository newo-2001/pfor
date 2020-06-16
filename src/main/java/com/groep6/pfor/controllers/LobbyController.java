package com.groep6.pfor.controllers;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.GameState;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.services.GameService;
import com.groep6.pfor.services.LobbyService;
import com.groep6.pfor.util.IEventCallback;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.LobbyView;
import javafx.application.Platform;

import java.util.Collections;
import java.util.List;

public class LobbyController extends Controller {

    public static final int MIN_PLAYERS = 0;

    private final Game game = Game.getInstance();
    private final Lobby lobby;

    /**
     * @param lobby
     */
    public LobbyController(Lobby lobby) {
        this.lobby = lobby;
        LobbyService.lobbyChangeEvent.subscribe(onLobbyChange);
        viewController.showView(new LobbyView(this));

        IEventCallback gameStartEvent = eventData -> {
            Game game = Game.getInstance();
            if (game.getLocalPlayer() != null && game.getLocalPlayer().isHost()) return;

            game.addPlayers(lobby.getLocalPlayer());
            game.setCode(lobby.getCode());
            onGameChange.onEvent(eventData);
            Game.setGameState(GameState.GAME);
            GameService.gameChangeEvent.subscribe(onGameChange);
            Platform.runLater(BoardController::new);
        };
        LobbyService.gameStartEvent.subscribe(gameStartEvent);
    }

    private final IEventCallback onGameChange = eventData -> {
        if (Config.DEBUG) System.out.println("Server update...");
        Game game = (Game) eventData[0];
        Game.getInstance().updateGame(game);

        if (game.isLost()) Platform.runLater(LoseController::new);
        else if (game.isWon()) Platform.runLater(WinController::new);
    };

    /**
     * @return lobby code
     */
    public String getLobbyCode() {
        return lobby.getCode();
    }

    /**
     * @return list of current lobbyPlayers in the lobby
     */
    public List<LobbyPlayer> getLobbyPlayers() {
        return lobby.getPlayers();
    }

    /**
     * Go to a new view: roleCardInfoView
     */
    public void goToRoleCardInfoView() {
        new RoleCardInfoController(lobby);
    }

    /**
     * Go to new view: MenuView
     */
    public void goToMenu() {
        // Delete from lobby
        LobbyService lobbyService = new LobbyService();
        LobbyPlayer player = lobby.getLocalPlayer();
        lobby.removePlayer(player);
        lobbyService.leave(player);

        if (player.isHost()) {
            boolean lobbyIsEmpty = lobby.getPlayers().size() == 0;

            if (lobbyIsEmpty) {
                lobbyService.remove(lobby);
            } else {
                lobbyService.giveHost(lobby.getPlayers().get(0));
            }
        }

        goBack();
        goBack();
    }

    public void startGame() {
        List<LobbyPlayer> players = lobby.getPlayers();
        Collections.shuffle(players);

        game.setCode(getLobbyCode());
        game.addPlayers(players.toArray(new LobbyPlayer[0]));
        game.getAllPlayers().get(0).setTurn();

        GameService gameService = new GameService();
        LobbyService lobbyService = new LobbyService();

        gameService.create(game);
        GameService.gameChangeEvent.subscribe(onGameChange);

        Game.setGameState(GameState.GAME);
        new BoardController();
        lobbyService.remove(lobby);

    }

    /**
     * @return local lobbyPlayer
     */
    public LobbyPlayer getLocalPlayer() {
        return lobby.getLocalPlayer();
    }

    /**
     * @return Host of the lobby
     */
    public LobbyPlayer getHost() {
        return lobby.getHost();
    }

    @Override
    public void registerObserver(IObserver view) {
        lobby.registerObserver(view);
    }


    /**
     * Run code every time the server sends an update
     */
    private final IEventCallback onLobbyChange = new IEventCallback() {
        @Override
        public void onEvent(Object... eventData) {
            Lobby serverLobby = (Lobby) eventData[0];

            if (!serverLobby.equals(lobby)) return;

            lobby.updateLobby(serverLobby);
        }
    };
}
