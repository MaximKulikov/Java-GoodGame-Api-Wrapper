package ru.maximkulikov.goodgame.api.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.mb3364.http.RequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.maximkulikov.goodgame.api.handlers.SmilesResponseHandler;
import ru.maximkulikov.goodgame.api.models.SmilesContainer;

/**
 * {@link SmilesResource} предоставляет функциональность к ресурсам smiles
 *
 * @author Maxim Kulikov
 * @since 04.01.2017
 */
public class SmilesResource extends AbstractResource {
    private static final Logger logger = LoggerFactory.getLogger(SmilesResource.class);
    private static final String PARAMETERS_NULL = "{} parameters should be > 0";
    private static final String PAGE = "page";

    public SmilesResource(final String baseUrl, final int apiVersion) {
        super(baseUrl, apiVersion);
    }

    protected SmilesResource(final String baseUrl) {
        super(baseUrl);
    }

    /**
     * Получение коллекции смайлов
     * Постраничный вывод по 50 объектов на страницу
     *
     * @param channelID Идентификатор канала
     * @param handler
     */
    public final boolean getChannelSmiles(final long channelID, final SmilesResponseHandler handler) {
        if (channelID < 0) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/smiles/%s", getBaseUrl(), channelID);

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение коллекции смайлов
     * Постраничный вывод по 50 объектов на страницу
     *
     * @param channelId Идентификатор канала
     * @param page      номер страницы
     * @param handler
     */
    public final boolean getChannelSmiles(final long channelId, final int page,
                                          final SmilesResponseHandler handler) {
        if (channelId < 0 || page < 0) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }

        String url = String.format("%s/smiles/%s", getBaseUrl(), channelId);

        RequestParams params = new RequestParams();
        params.put(PAGE, page);

        this.configureHeaders();
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение коллекции смайлов
     * Постраничный вывод по 50 объектов на страницу
     *
     * @param handler
     */
    public final boolean getSmiles(final SmilesResponseHandler handler) {
        String url = String.format("%s/smiles", getBaseUrl());

        this.configureHeaders();
        http.get(url, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }

    /**
     * Получение коллекции смайлов
     * Постраничный вывод по 50 объектов на страницу
     *
     * @param page    номер страницы
     * @param handler
     */
    public final boolean getSmiles(final int page, final SmilesResponseHandler handler) {
        if (page < 0) {
            logger.error(PARAMETERS_NULL, getClass().getEnclosingMethod().getName());
            return false;
        }
        String url = String.format("%s/smiles", getBaseUrl());
        RequestParams params = new RequestParams();
        params.put(PAGE, page);

        this.configureHeaders();
        http.get(url, params, new GoodGameHttpResponseHandler(handler) {
            @Override
            public void onSuccess(final int statusCode, final Map<String, List<String>> headers, final String content) {
                try {
                    SmilesContainer value = objectMapper.readValue(content, SmilesContainer.class);
                    handler.onSuccess(value);
                } catch (IOException e) {
                    logger.error("IOException {}", e.getLocalizedMessage());
                    handler.onFailure(e);
                }
            }
        });
        return true;
    }
}
