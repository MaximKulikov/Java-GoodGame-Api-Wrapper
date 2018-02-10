package ru.maximkulikov.goodgame.api;

import java.util.EnumMap;
import java.util.Map;
import ru.maximkulikov.goodgame.api.realization.*;

/**
 * Класс, реализующий библиотеку
 *
 * @author Maxim Kulikov
 * @since 25.12.2017
 */
public class GoodGameImplementation {

    private GoodGame gg;

    private Map<GoodGame.Resources, Object> realization;

    public GoodGameImplementation(GoodGame gg) {
        this.gg = gg;
        this.realization = new EnumMap<>(GoodGame.Resources.class);
        this.realization.put(GoodGame.Resources.OAUTH, new OauthRealization(gg));
        this.realization.put(GoodGame.Resources.PLAYER, new PlayerRealization(gg));
        this.realization.put(GoodGame.Resources.STREAMS, new StreamsRealization(gg));
        this.realization.put(GoodGame.Resources.CHANNELS, new ChannelsRealization(gg));
        this.realization.put(GoodGame.Resources.CHAT, new ChatRealization(gg));
        this.realization.put(GoodGame.Resources.GAMES, new GamesRealization(gg));
        this.realization.put(GoodGame.Resources.INFO, new InfoRealization(gg));
        this.realization.put(GoodGame.Resources.SMILES, new SmilesRealization(gg));
        this.realization.put(GoodGame.Resources.GITHUBAPI, new GithubRealization(gg));
        this.realization.put(GoodGame.Resources.AJAX, new AjaxRealization(gg));
    }

    public final AjaxRealization ajax() {
        return (AjaxRealization) realization.get(GoodGame.Resources.AJAX);
    }

    public final ChannelsRealization channels() {
        return (ChannelsRealization) realization.get(GoodGame.Resources.CHANNELS);
    }

    public final ChatRealization chat() {
        return (ChatRealization) realization.get(GoodGame.Resources.CHAT);
    }

    public final GamesRealization games() {
        return (GamesRealization) realization.get(GoodGame.Resources.GAMES);
    }

    public final GithubRealization github() {
        return (GithubRealization) realization.get(GoodGame.Resources.GITHUBAPI);
    }

    public final InfoRealization info() {
        return (InfoRealization) realization.get(GoodGame.Resources.INFO);
    }

    public final OauthRealization oauth() {
        return (OauthRealization) realization.get(GoodGame.Resources.OAUTH);
    }

    public final PlayerRealization player() {
        return (PlayerRealization) realization.get(GoodGame.Resources.PLAYER);
    }

    public final SmilesRealization smiles() {
        return (SmilesRealization) realization.get(GoodGame.Resources.SMILES);
    }

    public final StreamsRealization streams() {
        return (StreamsRealization) realization.get(GoodGame.Resources.STREAMS);
    }
}
