package ru.maximkulikov.goodgame.api.realization;

/**
 * Java-GoodGame-Api-Wrapper
 *
 * @author Maxim Kulikov
 * @since 25.12.2017
 */
public class GoodGameException extends Throwable {
    public GoodGameException(Throwable containerThrowable) {
        super(containerThrowable);
    }

}
