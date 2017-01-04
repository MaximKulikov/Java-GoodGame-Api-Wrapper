package ru.maximkulikov.goodgame.api.handlers;

import ru.maximkulikov.goodgame.api.models.SmilesContainer;

/**
 * Java-GG-Api-Wrapper
 * Created by maxim on 04.01.2017.
 */
public interface SmilesResponseHandler extends BaseFailureHandler {
    void onSuccess(SmilesContainer smiles);
}
