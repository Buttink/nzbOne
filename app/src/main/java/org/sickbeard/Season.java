/*
 * 	libSickBeard is a java library for communication with sickbeard
 * 	Copyright (C) 2012  David Stocking dmstocking@gmail.com
 * 
 * 	http://code.google.com/p/sick-stashe/
 * 	
 * 	libSickBeard is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 * 	
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 * 	
 * 	You should have received a copy of the GNU General Public License
 * 	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sickbeard;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import org.sickbeard.json.EpisodeJson;
import org.sickbeard.json.SeasonsJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@DatabaseTable(tableName = "tblShowXSeason")
public class Season {

    @DatabaseField(foreign =true, columnName = "season", uniqueCombo = true)
    public Show show;

    @DatabaseField(columnName = "season", uniqueCombo = true)
	public int season;

    @ForeignCollectionField(eager = true)
    public List<Episode> episodes;
	
	public Season( Show show, int season )
	{
        this.show = show;
		this.season = season;
	}
	
	public Season( Show show, int season, List<EpisodeJson> episodes )
	{
        this.show = show;
		this.season = season;
		for ( EpisodeJson json : episodes ) {
			this.episodes.add( new Episode( json ) );
		}
	}
	
	public Season( Show show, String season, SeasonsJson episodes )
	{
        this.show = show;
		this.season = Integer.parseInt(season);
		for ( Map.Entry<String, EpisodeJson> json : episodes.entrySet() ) {
			Episode ep = new Episode( json.getValue() );
			ep.episode = json.getKey();
			this.episodes.add( ep );
		}
	}
}
