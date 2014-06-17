package org.sickbeard;

import org.sickbeard.json.CommandsJson;
import org.sickbeard.json.EpisodeJson;
import org.sickbeard.json.GetQualityJson;
import org.sickbeard.json.HistoryJson;
import org.sickbeard.json.JsonResponse;
import org.sickbeard.json.MessageJson;
import org.sickbeard.json.OptionsJson;
import org.sickbeard.json.PingJson;
import org.sickbeard.json.RootDirJson;
import org.sickbeard.json.SeasonsJson;
import org.sickbeard.json.SeasonsListJson;
import org.sickbeard.json.ShowJson;
import org.sickbeard.json.TvDbResultsJson;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.client.Response;

// TODO implement the fancy functions the old sickbeard did
public class SickBeardService{

    private final ISickBeardService service;
    private final String api;

    public SickBeardService(ISickBeardService service, String api)
    {
        this.service = service;
        this.api = api;
    }

    public JsonResponse<EpisodeJson> Episode(int tvdbid, int season, int episode) {
		return service.Episode(api, tvdbid, season, episode);
	}

    public void Episode(int tvdbid, int season, int episode, Callback<JsonResponse<EpisodeJson>> callback) {
        service.Episode(api, tvdbid, season, episode, callback);
    }

    public JsonResponse<EpisodeJson> Episode(int tvdbid, int season, int episode, boolean fullPath) {
		return service.Episode(api, tvdbid, season, episode, fullPath);
	}

    public void Episode(int tvdbid, int season, int episode, boolean fullPath, Callback<JsonResponse<EpisodeJson>> callback) {
		service.Episode(api, tvdbid, season, episode, fullPath, callback);
	}
    
    public JsonResponse<Object> EpisodeSearch(int tvdbid, int season, int episode) {
		return service.EpisodeSearch(api, tvdbid, season, episode);
	}
    
    public void EpisodeSearch(int tvdbid, int season, int episode, Callback<JsonResponse<Object>> callback) {
		service.EpisodeSearch(api, tvdbid, season, episode, callback);
	}
    
    public JsonResponse<Object> EpisodeSetStatus(int tvdbid, int season, int episode, Episode.StatusEnum status) {
		return service.EpisodeSetStatus(api, tvdbid, season, episode, status);
	}
    
    public void EpisodeSetStatus(int tvdbid, int season, int episode, Episode.StatusEnum status, Callback<JsonResponse<Object>> callback) {
		service.EpisodeSetStatus(api, tvdbid, season, episode, status, callback);
	}

    public JsonResponse<ArrayList<String>> Exceptions(String tvdbid) {
		return service.Exceptions(api, tvdbid);
	}

    public void Exceptions(String tvdbid, Callback<JsonResponse<ArrayList<String>>> callback) {
		service.Exceptions(api, tvdbid, callback);
	}
    
    public JsonResponse<FutureEpisodes> future(FutureEpisodes.SortEnum sort) {
		return service.future(api, sort);
	}

    public void future(FutureEpisodes.SortEnum sort, Callback<JsonResponse<FutureEpisodes>> callback) {
		service.future(api, sort, callback);
	}

    public JsonResponse<HistoryJson> history(String api) {
		return service.history(api);
	}

    public void history(Callback<JsonResponse<HistoryJson>> callback) {
		service.history(api, callback);
	}

    public JsonResponse<HistoryJson> history(int limit) {
		return service.history(api, limit);
	}

    public void history(int limit, Callback<JsonResponse<HistoryJson>> callback) {
		service.history(api, limit, callback);
	}

    public JsonResponse<Object> historyClear(String api) {
		return service.historyClear(api);
	}

    public void historyClear(Callback<JsonResponse<Object>> callback) {
		service.historyClear(api, callback);
	}

    public JsonResponse<Object> historyTrim(String api) {
		return service.historyTrim(api);
	}

    public void historyTrim(Callback<JsonResponse<Object>> callback) {
		service.historyTrim(api, callback);
	}

    public JsonResponse<Logs> logs(String api) {
		return service.logs(api);
	}

    public void logs(Callback<JsonResponse<Logs>> callback) {
		service.logs(api, callback);
	}

    public JsonResponse<Logs> logs(Logs.LevelEnum minLevel) {
		return service.logs(api, minLevel);
	}

    public void logs(Logs.LevelEnum minLevel, Callback<JsonResponse<Logs>> callback) {
		service.logs(api, minLevel, callback);
	}

    public JsonResponse<ShowJson> show(String tvdbid) {
		return service.show(api, tvdbid);
	}

    public void show(String tvdbid, Callback<JsonResponse<ShowJson>> callback) {
		service.show(api, tvdbid, callback);
	}

    public JsonResponse<Object> showAddNew(String tvdbid) {
		return service.showAddNew(api, tvdbid);
	}

    public void showAddNew(String tvdbid, Callback<JsonResponse<Object>> callback) {
		service.showAddNew(api, tvdbid, callback);
	}

    public JsonResponse<Object> showAddNew(String tvdbid, LanguageEnum language, Boolean seasonFolders, Episode.StatusEnum status, EnumSet<Show.QualityEnum> initial, EnumSet<Show.QualityEnum> archive) {
		return service.showAddNew(api, tvdbid, language, seasonFolders, status, initial, archive);
	}

    public void showAddNew(String tvdbid, LanguageEnum language, Boolean seasonFolders, Episode.StatusEnum status, EnumSet<Show.QualityEnum> initial, EnumSet<Show.QualityEnum> archive, Callback<JsonResponse<Object>> callback) {
		service.showAddNew(api, tvdbid, language, seasonFolders, status, initial, archive, callback);
	}

    public JsonResponse<CacheStatus> showCache(String tvdbid) {
		return service.showCache(api, tvdbid);
	}

    public void showCache(String tvdbid, Callback<JsonResponse<CacheStatus>> callback) {
		service.showCache(api, tvdbid, callback);
	}

    public JsonResponse<Object> showDelete(String tvdbid) {
		return service.showDelete(api, tvdbid);
	}

    public void showDelete(String tvdbid, Callback<JsonResponse<Object>> callback) {
		service.showDelete(api, tvdbid, callback);
	}

    public Response showGetBanner(String tvdbid) {
        return service.showGetBanner(api, tvdbid);
    }

    public void showGetBanner(String tvdbid, Callback<Response> callback) {
		service.showGetBanner(api, tvdbid, callback);
	}

    public Response showGetPoster(String tvdbid) {
        return service.showGetPoster(api, tvdbid);
    }

    public void showGetPoster(String tvdbid, Callback<Response> callback) {
		service.showGetPoster(api, tvdbid, callback);
	}

    public JsonResponse<GetQualityJson> showGetQuality(String tvdbid) {
		return service.showGetQuality(api, tvdbid);
	}

    public void showGetQuality(String tvdbid, Callback<JsonResponse<GetQualityJson>> callback) {
		service.showGetQuality(api, tvdbid, callback);
	}

    public JsonResponse<Object> showPause(String tvdbid, Boolean pause) {
		return service.showPause(api, tvdbid, pause);
	}

    public void showPause(String tvdbid, Boolean pause, Callback<JsonResponse<Object>> callback) {
		service.showPause(api, tvdbid, pause, callback);
	}

    public JsonResponse<Object> showRefresh(String tvdbid) {
		return service.showRefresh(api, tvdbid);
	}

    public void showRefresh(String tvdbid, Callback<JsonResponse<Object>> callback) {
		service.showRefresh(api, tvdbid, callback);
	}

    public JsonResponse<ArrayList<Integer>> showSeasonList(String tvdbid) {
		return service.showSeasonList(api, tvdbid);
	}

    public void showSeasonList(String tvdbid, Callback<JsonResponse<ArrayList<Integer>>> callback) {
		service.showSeasonList(api, tvdbid, callback);
	}

    public JsonResponse<SeasonsListJson> showSeasons(String tvdbid) {
		return service.showSeasons(api, tvdbid);
	}

    public void showSeasons(String tvdbid, Callback<JsonResponse<SeasonsListJson>> callback) {
		service.showSeasons(api, tvdbid, callback);
	}

    public JsonResponse<SeasonsJson> showSeasons(String tvdbid, String season) {
		return service.showSeasons(api, tvdbid, season);
	}

    public void showSeasons(String tvdbid, String season, Callback<SeasonsJson> callback) {
		service.showSeasons(api, tvdbid, season, callback);
	}

    public JsonResponse<Object> showSetQuality(String tvdbid, EnumSet<Show.QualityEnum> initial, EnumSet<Show.QualityEnum> archive) {
		return service.showSetQuality(api, tvdbid, initial, archive);
	}

    public void showSetQuality(String tvdbid, EnumSet<Show.QualityEnum> initial, EnumSet<Show.QualityEnum> archive, Callback<JsonResponse<Object>> callback) {
		service.showSetQuality(api, tvdbid, initial, archive, callback);
	}

    public JsonResponse<Object> showUpdate(String tvdbid) {
		return service.showUpdate(api, tvdbid);
	}

    public void showUpdate(String tvdbid, Callback<JsonResponse<Object>> callback) {
		service.showUpdate(api, tvdbid, callback);
	}

    public JsonResponse<HashMap<String, ShowJson>> shows(String api) {
		return service.shows(api);
	}

    public void shows(Callback<JsonResponse<HashMap<String, ShowJson>>> callback) {
		service.shows(api, callback);
	}

    public JsonResponse<Object> sbForceSearch(String api) {
		return service.sbForceSearch(api);
	}

    public void sbForceSearch(Callback<JsonResponse<Object>> callback) {
		service.sbForceSearch(api, callback);
	}

    public JsonResponse<CommandsJson> sbGetCommands(String api) {
		return service.sbGetCommands(api);
	}

    public void sbGetCommands(Callback<JsonResponse<CommandsJson>> callback) {
		service.sbGetCommands(api, callback);
	}

    public JsonResponse<OptionsJson> sbGetDefaults(String api) {
		return service.sbGetDefaults(api);
	}

    public void sbGetDefaults(Callback<JsonResponse<OptionsJson>> callback) {
		service.sbGetDefaults(api, callback);
	}

    public JsonResponse<ArrayList<MessageJson>> sbGetMessages(String api) {
		return service.sbGetMessages(api);
	}

    public void sbGetMessages(Callback<JsonResponse<ArrayList<MessageJson>>> callback) {
		service.sbGetMessages(api, callback);
	}

    public JsonResponse<ArrayList<RootDirJson>> sbGetRootDirs(String api) {
		return service.sbGetRootDirs(api);
	}

    public void sbGetRootDirs(Callback<JsonResponse<ArrayList<RootDirJson>>> callback) {
		service.sbGetRootDirs(api, callback);
	}

    public JsonResponse<Object> sbPauseBackLogSearch(String api) {
		return service.sbPauseBackLogSearch(api);
	}

    public void sbPauseBackLogSearch(Callback<JsonResponse<Object>> callback) {
		service.sbPauseBackLogSearch(api, callback);
	}

    public JsonResponse<PingJson> sbPing(String api) {
		return service.sbPing(api);
	}

    public void sbPing(Callback<JsonResponse<PingJson>> callback) {
		service.sbPing(api, callback);
	}

    public JsonResponse<Object> sbRestart(String api) {
		return service.sbRestart(api);
	}

    public void sbRestart(Callback<JsonResponse<Object>> callback) {
		service.sbRestart(api, callback);
	}
    
    public JsonResponse<TvDbResultsJson> sbSearchTvDb(String query, LanguageEnum language) {
		return service.sbSearchTvDb(api, query, language);
	}
    
    public void sbSearchTvDb(String query, LanguageEnum language, Callback<JsonResponse<TvDbResultsJson>> callback) {
		service.sbSearchTvDb(api, query, language, callback);
	}

    public JsonResponse<Object> sbShutdown(String api) {
		return service.sbShutdown(api);
	}

    public void sbShutdown(Callback<JsonResponse<Object>> callback) {
		service.sbShutdown(api, callback);
	}
}
