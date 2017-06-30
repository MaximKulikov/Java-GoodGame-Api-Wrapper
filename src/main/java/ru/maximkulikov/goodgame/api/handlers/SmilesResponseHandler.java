package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.SmilesContainer;

/**
 * Обработчик методов ресурса {@link ru.maximkulikov.goodgame.api.resources.SmilesResource}
 *
 * @author Maxim Kulikov
 * @since 04.01.20017
 */
public interface SmilesResponseHandler extends BaseFailureHandler {
    /**
     * @param smiles
     */
    void onSuccess(SmilesContainer smiles);
}
