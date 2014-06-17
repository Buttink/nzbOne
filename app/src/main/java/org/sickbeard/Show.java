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

import org.sickbeard.json.ShowJson;
import org.sickbeard.json.ShowJson.QualityDetailsJson;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@DatabaseTable(tableName = "tblShows")
public class Show {
	
	public enum QualityEnum {
		SDTV("SD TV"),
        SDDVD("SD DVD"),
        HDTV("HD TV"),
        RAWHDTV("RawHD TV"),
        FULLHDTV("1080p HD TV"),
        HDWEBDL("720p WEB-DL"),
        FULLHDWEBDL("1080p WEB-DL"),
        HDBLURAY("720p BluRay"),
        FULLHDBLURAY("1080p BluRay"),
        UNKNOWN("Unknown");

        private final String displayName;

        QualityEnum(String displayName)
        {
            this.displayName = displayName;
        }

        public String toJson()
        {
            return super.toString();
        }

        @Override
        public String toString()
        {
            return displayName;
        }

		public static QualityEnum fromJson(String quality)
		{
			return QualityEnum.valueOf(quality.toUpperCase());
		}
		
		public static String[] valuesToString()
		{
			QualityEnum[] enums = QualityEnum.values();
			String[] items = new String[enums.length];
			for ( int i=0; i < enums.length; i++ ) {
				items[i] = enums[i].toString();
			}
			return items;
		}
		
		public static QualityEnum fromOrdinal(int index)
		{
			return QualityEnum.values()[index];
		}
		
		public static EnumSet<QualityEnum> fromBooleans(boolean[] values)
		{
			QualityEnum[] enums = QualityEnum.values();
			if ( values.length != enums.length )
				throw new RuntimeException("QualityEnum.fromBoolens: Array Mismatch values must be length \"" + enums.length + "\"");
			EnumSet<QualityEnum> ret = EnumSet.noneOf(QualityEnum.class);
			for ( int i=0; i < enums.length; i++ ) {
				if ( values[i] )
					ret.add(enums[i]);
			}
			return ret;
		}
	}
    @DatabaseField(id = true, columnName = "id")
	public String id;
    @DatabaseField(columnName = "air_by_date")
	public boolean airbydate;
    @DatabaseField(columnName = "air_by_date")
	public String airs;
    @DatabaseField(foreign = true, columnName = "cache")
	public CacheStatus cache;
    @ForeignCollectionField(eager = false)
	public List<String> genre;
    @DatabaseField(columnName = "language")
	public String language;
    @DatabaseField(columnName = "location")
	public String location;
    @DatabaseField(columnName = "network")
	public String network;
    @DatabaseField(columnName = "next_air_date")
	public String nextAirDate;
    @DatabaseField(columnName = "paused")
	public boolean paused;
    @DatabaseField(columnName = "quality")
	public String quality;
    @ForeignCollectionField(eager = false)
	public List<QualityEnum> archive;
    @ForeignCollectionField(eager = false)
    public List<QualityEnum> initial;
    @DatabaseField(columnName = "season_folders")
	public boolean seasonFolders;
    @ForeignCollectionField(eager = true)
	public List<Season> seasonList;
    @DatabaseField(columnName = "show_name")
	public String showName;
    @DatabaseField(columnName = "status")
	public String status;
    @DatabaseField(columnName = "tvrage_id")
	public int tvrageId;
    @DatabaseField(columnName = "tvrage_name")
	public String tvrageName;

	public Show( ShowJson json )
	{
		id = json.id;
		airbydate = json.air_by_date.value;
		airs = json.airs;
		cache = new CacheStatus( json.cache );
		cache.banner = json.cache.banner.value;
		cache.poster = json.cache.poster.value;
		genre = (json.genre != null ? json.genre : new ArrayList<String>());
		language = json.language;
		location = json.location;
		network = json.network;
		nextAirDate = json.next_ep_airdate;
		paused = json.paused.value;
		quality = json.quality;
        archive = json.quality_details.archive;
        initial = json.quality_details.initial;
		seasonFolders = json.season_folders.value;
		seasonList = new ArrayList<Season>();
		if ( json.season_list != null ) {
			for ( Integer s : json.season_list ) {
				seasonList.add(new Season(s));
			}
		}
		showName = json.show_name;
		status = json.status;
		tvrageId = json.tvrage_id;
		tvrageName = json.tvrage_name;
	}
}
