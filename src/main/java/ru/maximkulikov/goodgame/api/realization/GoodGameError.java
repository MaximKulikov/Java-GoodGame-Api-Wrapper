package ru.maximkulikov.goodgame.api.realization;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 25.12.2017
 */
public class GoodGameError extends Throwable {
    public GoodGameError(String message) {
        super(message);
    }
}
