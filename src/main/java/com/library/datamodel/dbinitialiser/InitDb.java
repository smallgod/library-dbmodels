/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.dbinitialiser;

import com.library.customexception.MyCustomException;
import com.library.datamodel.Constants.AdScreenType;
import com.library.datamodel.Constants.AdXpoAccountStatus;
import com.library.datamodel.Constants.NamedConstants;
import com.library.datamodel.Constants.ScreenSplit;
import com.library.datamodel.jaxb.config.v1_0.Amounttype;
import com.library.datamodel.model.v1_0.AdAudienceType;
import com.library.datamodel.model.v1_0.AdBusiness;
import com.library.datamodel.model.v1_0.AdBusinessService;
import com.library.datamodel.model.v1_0.AdClient;
import com.library.datamodel.model.v1_0.AdScreen;
import com.library.datamodel.model.v1_0.AdScreenLayout;
import com.library.datamodel.model.v1_0.AdScreenSize;
import com.library.datamodel.model.v1_0.AdTerminal;
import com.library.datamodel.model.v1_0.AdTimeSlot;
import com.library.datamodel.model.v1_0.AdUser;
import com.library.hibernate.CustomHibernate;
import com.library.httpconnmanager.Security;
import com.library.hibernate.utils.HibernateUtils;
import com.library.sglogger.util.LoggerUtil;
import com.library.utilities.NumericIDGenerator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

/**
 *
 * @author smallgod
 */
public class InitDb {

//    private static final LoggerUtil logger = new LoggerUtil(InitDb.class);
//
//    //areas
//    private AdArea area1;
//    private AdArea area2;
//    private AdArea area3;
//    private AdArea area4;
//    private AdArea area5;
//    private AdArea area6;
//    private AdArea area7;
//    private AdArea area8;
//    private AdArea area9;
//    private AdArea area10;
//    private AdArea area11;
//    private AdArea area12;
//    private AdArea area13;
//    private AdArea area14;
//    private AdArea area15;
//    private AdArea area16;
//    private AdArea area17;
//    private AdArea area18;
//    private AdArea area19;
//    private AdArea area20;
//    private AdArea area21;
//
//    //AdAudience types
//    private AdAudienceType aud1;
//    private AdAudienceType aud2;
//    private AdAudienceType aud3;
//    private AdAudienceType aud4;
//    private AdAudienceType aud5;
//    private AdAudienceType aud6;
//    private AdAudienceType aud7;
//    private AdAudienceType aud8;
//    private AdAudienceType aud9;
//    private AdAudienceType aud10;
//    private AdAudienceType aud11;
//    private AdAudienceType aud12;
//
//    //Business types
//    private AdBusinessType bus1;
//    private AdBusinessType bus2;
//    private AdBusinessType bus3;
//    private AdBusinessType bus4;
//    private AdBusinessType bus5;
//    private AdBusinessType bus6;
//    private AdBusinessType bus7;
//    private AdBusinessType bus8;
//    private AdBusinessType bus9;
//    private AdBusinessType bus10;
//    private AdBusinessType bus11;
//    private AdBusinessType bus12;
//    private AdBusinessType bus13;
//    private AdBusinessType bus14;
//    private AdBusinessType bus15;
//
//    private AdUser testUser;
//    private AdUser guestUser;
//    private AdUser templatesCampaignUser;
//    private AdClient testAdClient;
//    private AdClient guestAdClient;
//    private AdClient templatesCampaignClient;
//
//    private final CustomHibernate customHibernate;
//
//    //Test businesses
//    private Set<AdBusiness> testBusinesses = new HashSet<>();
//    //private Set<AdBusiness> productionBusinesses = new HashSet<>();
//
//    //advertising screens
//    private Set<AdScreen> adScreens = new HashSet<>();
//
//    private AdBusiness busy1;
//    private AdBusiness busy2;
//    private AdBusiness busy3;
//    private AdBusiness busy4;
//    private AdBusiness busy5;
//    private AdBusiness busy6;
//    private AdBusiness busy7;
//    private AdBusiness busy8;
//    private AdBusiness busy9;
//    private AdBusiness busy10;
//    private AdBusiness busy11;
//    private AdBusiness busy12;
//    private AdBusiness busy13;
//    private AdBusiness busy14;
//    private AdBusiness busy15;
//    private AdBusiness busy16;
//    private AdBusiness busy17;
//    private AdBusiness busy18;
//    private AdBusiness busy19;
//    private AdBusiness busy20;
//    private AdBusiness busy21;
//    private AdBusiness busy22;
//    private AdBusiness busy23;
//    private AdBusiness busy24;
//    private AdBusiness busy26;
//    private AdBusiness busy27;
//    private AdBusiness busy41;
//    private AdBusiness busy40;
//    private AdBusiness busy39;
//    private AdBusiness busy38;
//    private AdBusiness busy36;
//    private AdBusiness busy35;
//    private AdBusiness busy34;
//    private AdBusiness busy33;
//    private AdBusiness busy32;
//    private AdBusiness busy31;
//    private AdBusiness busy30;
//    private AdBusiness busy29;
//    private AdBusiness busy37;
//    private AdBusiness busy42;
//    private AdBusiness busy43;
//    private AdBusiness busy44;
//    private AdBusiness busy45;
//    private AdBusiness busy46;
//    private AdBusiness busy47;
//
//    public InitDb(CustomHibernate customHibernate) {
//        this.customHibernate = customHibernate;
//    }
//
//    /**
//     * Add possible areas/locations
//     *
//     * @throws MyCustomException
//     */
//    public void addPossibleAreas() throws MyCustomException {
//
//        //I think some identifying info should belong to the screens
//        area1 = new AdArea();
//        String code1 = generate();
//        area1.setAreaCode(code1);
//        area1.setCountry("Uganda");
//        area1.setDistrict("Kampala");
//        area1.setRegion("Central");
//        area1.setAreaName("Bugolobi");
//        area1.setSubArea1("");
//        area1.setSubArea2("");
//
//        area2 = new AdArea();
//        String code2 = generate();
//        area2.setAreaCode(code2);
//        area2.setCountry("Uganda");
//        area2.setDistrict("Kampala");
//        area2.setRegion("Central");
//        area2.setAreaName("Bweyogerere");
//        area2.setSubArea1("");
//        area2.setSubArea2("");
//
//        area3 = new AdArea();
//        String code3 = generate();
//        area3.setAreaCode(code3);
//        area3.setCountry("Uganda");
//        area3.setDistrict("Kampala");
//        area3.setRegion("Central");
//        area3.setAreaName("City centre");
//        area3.setSubArea1("");
//        area3.setSubArea2("");
//
//        area4 = new AdArea();
//        String code4 = generate();
//        area4.setAreaCode(code4);
//        area4.setCountry("Uganda");
//        area4.setDistrict("Kampala");
//        area4.setRegion("Central");
//        area4.setAreaName("Kabalagala");
//        area4.setSubArea1("");
//        area4.setSubArea2("");
//
//        area5 = new AdArea();
//        String code5 = generate();
//        area5.setAreaCode(code5);
//        area5.setCountry("Uganda");
//        area5.setDistrict("Kampala");
//        area5.setRegion("Central");
//        area5.setAreaName("Kamwokya");
//        area5.setSubArea1("");
//        area5.setSubArea2("");
//
//        area6 = new AdArea();
//        String code6 = generate();
//        area6.setAreaCode(code6);
//        area6.setCountry("Uganda");
//        area6.setDistrict("Kampala");
//        area6.setRegion("Central");
//        area6.setAreaName("Namungoona");
//        area6.setSubArea1("");
//        area6.setSubArea2("");
//
//        area7 = new AdArea();
//        String code7 = generate();
//        area7.setAreaCode(code7);
//        area7.setCountry("Uganda");
//        area7.setDistrict("Kampala");
//        area7.setRegion("Central");
//        area7.setAreaName("Ntinda");
//
//        area8 = new AdArea();
//        String code8 = generate();
//        area8.setAreaCode(code8);
//        area8.setCountry("Uganda");
//        area8.setDistrict("Kampala");
//        area8.setRegion("Central");
//        area8.setAreaName("Kalerwe");
//
//        area9 = new AdArea();
//        String code9 = generate();
//        area9.setAreaCode(code9);
//        area9.setCountry("Uganda");
//        area9.setDistrict("Kampala");
//        area9.setRegion("Central");
//        area9.setAreaName("Kololo");
//
//        area10 = new AdArea();
//        String code10 = generate();
//        area10.setAreaCode(code10);
//        area10.setCountry("Uganda");
//        area10.setDistrict("Kampala");
//        area10.setRegion("Central");
//        area10.setAreaName("Lubowa");
//
//        area11 = new AdArea();
//        String code11 = generate();
//        area11.setAreaCode(code11);
//        area11.setCountry("Uganda");
//        area11.setDistrict("Kampala");
//        area11.setRegion("Central");
//        area11.setAreaName("Makerere");
//
//        area12 = new AdArea();
//        String code12 = generate();
//        area12.setAreaCode(code12);
//        area12.setCountry("Uganda");
//        area12.setDistrict("Kampala");
//        area12.setRegion("Central");
//        area12.setAreaName("Nakawa");
//
//        area13 = new AdArea();
//        String code13 = generate();
//        area13.setAreaCode(code13);
//        area13.setCountry("Uganda");
//        area13.setDistrict("Kampala");
//        area13.setRegion("Central");
//        area13.setAreaName("Nakulabye");
//
//        area14 = new AdArea();
//        String code14 = generate();
//        area14.setAreaCode(code14);
//        area14.setCountry("Uganda");
//        area14.setDistrict("Kampala");
//        area14.setRegion("Central");
//        area14.setAreaName("Wankulukuku");
//
//        area15 = new AdArea();
//        String code15 = generate();
//        area15.setAreaCode(code15);
//        area15.setCountry("Uganda");
//        area15.setDistrict("Mbarara");
//        area15.setRegion("West");
//        area15.setAreaName("Town");
//
//        area16 = new AdArea();
//        String code16 = generate();
//        area16.setAreaCode(code16);
//        area16.setCountry("Uganda");
//        area16.setDistrict("Mbarara");
//        area16.setRegion("West");
//        area16.setAreaName("MUST");
//
//        area17 = new AdArea();
//        String code17 = generate();
//        area17.setAreaCode(code17);
//        area17.setCountry("Uganda");
//        area17.setDistrict("Kampala");
//        area17.setRegion("Central");
//        area17.setAreaName("Kyanja");
//
//        area18 = new AdArea();
//        String code18 = generate();
//        area18.setAreaCode(code18);
//        area18.setCountry("Uganda");
//        area18.setDistrict("Kampala");
//        area18.setRegion("Central");
//        area18.setAreaName("Kisasi");
//
//        area19 = new AdArea();
//        String code19 = generate();
//        area19.setAreaCode(code19);
//        area19.setCountry("Uganda");
//        area19.setDistrict("Kampala");
//        area19.setRegion("Central");
//        area19.setAreaName("Kutaano");
//
//        area20 = new AdArea();
//        String code20 = generate();
//        area20.setAreaCode(code20);
//        area20.setCountry("Uganda");
//        area20.setDistrict("Kampala");
//        area20.setRegion("Central");
//        area20.setAreaName("Kyanja");
//        area20.setSubArea1("Ndundu");
//        area20.setSubArea2("");
//
//        area21 = new AdArea();
//        String code21 = generate();
//        area21.setAreaCode(code21);
//        area21.setCountry("Uganda");
//        area21.setDistrict("Jinja");
//        area21.setRegion("East");
//        area21.setAreaName("Town");
//        area21.setSubArea1("");
//        area21.setSubArea2("");
//
//        Set<AdArea> testAreas = new HashSet<>();
//        testAreas.add(area1);
//        testAreas.add(area2);
//        testAreas.add(area3);
//        testAreas.add(area4);
//        testAreas.add(area5);
//        testAreas.add(area6);
//        testAreas.add(area7);
//        testAreas.add(area8);
//        testAreas.add(area9);
//        testAreas.add(area10);
//        testAreas.add(area11);
//        testAreas.add(area12);
//        testAreas.add(area13);
//        testAreas.add(area14);
//        testAreas.add(area15);
//        testAreas.add(area16);
//        testAreas.add(area17);
//        testAreas.add(area18);
//        testAreas.add(area19);
//        testAreas.add(area20);
//        testAreas.add(area21);
//
//        customHibernate.saveBulk(testAreas);
//    }
//
//    /**
//     *
//     * @throws MyCustomException
//     */
//    public void addAudienceTypes() throws MyCustomException {
//
//        aud1 = new AdAudienceType();
//        String code1 = generate();
//        aud1.setAudienceCode(code1);
//        aud1.setAudienceName("Corporates");
//
//        aud2 = new AdAudienceType();
//        String code2 = generate();
//        aud2.setAudienceCode(code2);
//        aud2.setAudienceName("Expats");
//
//        aud3 = new AdAudienceType();
//        String code3 = generate();
//        aud3.setAudienceCode(code3);
//        aud3.setAudienceName("Families");
//
//        aud4 = new AdAudienceType();
//        String code4 = generate();
//        aud4.setAudienceCode(code4);
//        aud4.setAudienceName("Mainly men");
//
//        aud5 = new AdAudienceType();
//        String code5 = generate();
//        aud5.setAudienceCode(code5);
//        aud5.setAudienceName("Mainly women");
//
//        aud6 = new AdAudienceType();
//        String code6 = generate();
//        aud6.setAudienceCode(code6);
//        aud6.setAudienceName("Students");
//
//        aud7 = new AdAudienceType();
//        String code7 = generate();
//        aud7.setAudienceCode(code7);
//        aud7.setAudienceName("Tourists");
//
//        aud8 = new AdAudienceType();
//        String code8 = generate();
//        aud8.setAudienceCode(code8);
//        aud8.setAudienceName("Traders");
//
//        aud9 = new AdAudienceType();
//        String code9 = generate();
//        aud9.setAudienceCode(code9);
//        aud9.setAudienceName("Upscale");
//
//        aud10 = new AdAudienceType();
//        String code10 = generate();
//        aud10.setAudienceCode(code10);
//        aud10.setAudienceName("Boda-boda cyclists");
//
//        aud11 = new AdAudienceType();
//        String code11 = generate();
//        aud11.setAudienceCode(code11);
//        aud11.setAudienceName("Business people");
//
//        aud12 = new AdAudienceType();
//        String code12 = generate();
//        aud11.setAudienceCode(code12);
//        aud11.setAudienceName("Taxi drivers");
//
//        Set<AdAudienceType> audienceTypes = new HashSet<>();
//        audienceTypes.add(aud1);
//        audienceTypes.add(aud2);
//        audienceTypes.add(aud3);
//        audienceTypes.add(aud4);
//        audienceTypes.add(aud5);
//        audienceTypes.add(aud6);
//        audienceTypes.add(aud7);
//        audienceTypes.add(aud8);
//        audienceTypes.add(aud9);
//        audienceTypes.add(aud10);
//        audienceTypes.add(aud11);
//        audienceTypes.add(aud12);
//
//        customHibernate.saveBulk(audienceTypes);
//
//    }
//
//    /**
//     *
//     * @throws MyCustomException
//     */
//    public void addBusinessTypes() throws MyCustomException {
//        //BAR | SALON | SPORTS_HOUSE | HOTEL | HOSTELS | SCHOOLS | UNIVERSITIES | AIRPORT | BIBANDA | RESTAURANT | SUPERMARKET | SHOP
//
//        bus1 = new AdBusinessType();
//        String code1 = generate();
//        bus1.setBusinessTypeCode(code1);
//        bus1.setBusinessTypeName("Bar");
//        bus1.setBusinessTypeshortName("bar");
//
//        bus2 = new AdBusinessType();
//        String code2 = generate();
//        bus2.setBusinessTypeCode(code2);
//        bus2.setBusinessTypeName("Salon");
//        bus2.setBusinessTypeshortName("salon");
//
//        bus3 = new AdBusinessType();
//        String code3 = generate();
//        bus3.setBusinessTypeCode(code3);
//        bus3.setBusinessTypeName("Sports Betting");
//        bus3.setBusinessTypeshortName("betting");
//
//        bus4 = new AdBusinessType();
//        String code4 = generate();
//        bus4.setBusinessTypeCode(code4);
//        bus4.setBusinessTypeName("Small Shop");
//        bus4.setBusinessTypeshortName("shop");
//
//        bus5 = new AdBusinessType();
//        String code5 = generate();
//        bus5.setBusinessTypeCode(code5);
//        bus5.setBusinessTypeName("Local cinema - Kibanda");
//        bus5.setBusinessTypeshortName("kibanda");
//
//        bus6 = new AdBusinessType();
//        String code6 = generate();
//        bus6.setBusinessTypeCode(code6);
//        bus6.setBusinessTypeName("Hotel");
//        bus6.setBusinessTypeshortName("hotel");
//
//        bus7 = new AdBusinessType();
//        String code7 = generate();
//        bus7.setBusinessTypeCode(code7);
//        bus7.setBusinessTypeName("Hostel");
//        bus7.setBusinessTypeshortName("hostel");
//
//        bus8 = new AdBusinessType();
//        String code8 = generate();
//        bus8.setBusinessTypeCode(code8);
//        bus8.setBusinessTypeName("School");
//        bus8.setBusinessTypeshortName("school");
//
//        bus9 = new AdBusinessType();
//        String code9 = generate();
//        bus9.setBusinessTypeCode(code9);
//        bus9.setBusinessTypeName("University");
//        bus9.setBusinessTypeshortName("versity");
//
//        bus10 = new AdBusinessType();
//        String code10 = generate();
//        bus10.setBusinessTypeCode(code10);
//        bus10.setBusinessTypeName("Aiport");
//        bus10.setBusinessTypeshortName("airport");
//
//        bus11 = new AdBusinessType();
//        String code11 = generate();
//        bus11.setBusinessTypeCode(code11);
//        bus11.setBusinessTypeName("Restaurant");
//        bus11.setBusinessTypeshortName("restaurant");
//
//        bus12 = new AdBusinessType();
//        String code12 = generate();
//        bus12.setBusinessTypeCode(code12);
//        bus12.setBusinessTypeName("Super market");
//        bus12.setBusinessTypeshortName("supermarket");
//
//        bus13 = new AdBusinessType();
//        String code13 = generate();
//        bus13.setBusinessTypeCode(code13);
//        bus13.setBusinessTypeName("Community audience");
//        bus13.setBusinessTypeshortName("community");
//
//        bus14 = new AdBusinessType();
//        String code14 = generate();
//        bus14.setBusinessTypeCode(code14);
//        bus14.setBusinessTypeName("Casino");
//        bus14.setBusinessTypeshortName("casino");
//
//        bus15 = new AdBusinessType();
//        String code15 = generate();
//        bus15.setBusinessTypeCode(code15);
//        bus15.setBusinessTypeName("Hospital");
//        bus15.setBusinessTypeshortName("hospital");
//
//        Set<AdBusinessType> businessTypes = new HashSet<>();
//
//        businessTypes.add(bus1);
//        businessTypes.add(bus2);
//        businessTypes.add(bus3);
//        businessTypes.add(bus4);
//        businessTypes.add(bus5);
//        businessTypes.add(bus6);
//        businessTypes.add(bus7);
//        businessTypes.add(bus8);
//        businessTypes.add(bus9);
//        businessTypes.add(bus10);
//        businessTypes.add(bus11);
//        businessTypes.add(bus12);
//        businessTypes.add(bus13);
//        businessTypes.add(bus14);
//        businessTypes.add(bus15);
//
//        customHibernate.saveBulk(businessTypes);
//
//    }
//
//    /**
//     * Test location business owners data
//     *
//     * @throws MyCustomException
//     */
//    public void addTestBusinesses() throws MyCustomException {
//
//        busy1 = new AdBusiness();
//        busy1.setBusinessName("Le Village Wines");
//        busy1.setBusinessId("LEVI");
//        busy1.setIsDefault(true);
//        busy1.setNumberOfScreens(1);
//        busy1.setPhoneContact("256790790491");
//
//        busy2 = new AdBusiness();
//        busy2.setBusinessName("Katch the Sun");
//        busy2.setIsDefault(true);
//        busy2.setBusinessId("KSUN");
//        busy2.setNumberOfScreens(1);
//        busy2.setPhoneContact("256790790491");
//
//        busy3 = new AdBusiness();
//        busy3.setBusinessName("Nakumatt");
//        busy3.setIsDefault(true);
//        busy3.setBusinessId("NKMT");
//        busy3.setNumberOfScreens(1);
//        busy3.setPhoneContact("256790790491");
//
//        busy4 = new AdBusiness();
//        busy4.setBusinessName("Top Bets");
//        busy4.setIsDefault(true);
//        busy4.setBusinessId("TOPB");
//        busy4.setNumberOfScreens(1);
//        busy4.setPhoneContact("256790790491");
//
//        busy5 = new AdBusiness();
//        busy5.setBusinessName("Equatoria Hotel");
//        busy5.setIsDefault(true);
//        busy5.setBusinessId("EQUA");
//        busy5.setNumberOfScreens(1);
//        busy5.setPhoneContact("256790790491");
//
//        busy6 = new AdBusiness();
//        busy6.setBusinessName("Mayfair Casino");
//        busy6.setIsDefault(true);
//        busy6.setBusinessId("MAYF");
//        busy6.setNumberOfScreens(1);
//        busy6.setPhoneContact("256790790491");
//
//        busy7 = new AdBusiness();
//        busy7.setBusinessName("Norvik Hospital");
//        busy7.setIsDefault(true);
//        busy7.setBusinessId("NORV");
//        busy7.setNumberOfScreens(1);
//        busy7.setPhoneContact("256790790491");
//
//        busy8 = new AdBusiness();
//        busy8.setBusinessName("Ethiopian Village Restaurant ");
//        busy8.setIsDefault(true);
//        busy8.setBusinessId("EVIL");
//        busy8.setNumberOfScreens(1);
//        busy8.setPhoneContact("256790790491");
//
//        busy9 = new AdBusiness();
//        busy9.setBusinessName("Muriel's Restaurant");
//        busy9.setIsDefault(true);
//        busy9.setBusinessId("MURI");
//        busy9.setNumberOfScreens(1);
//        busy9.setPhoneContact("256790790491");
//
//        busy10 = new AdBusiness();
//        busy10.setBusinessName("Iguana Lounge");
//        busy10.setIsDefault(true);
//        busy10.setBusinessId("IGUA");
//        busy10.setNumberOfScreens(1);
//        busy10.setPhoneContact("256790790491");
//
//        busy11 = new AdBusiness();
//        busy11.setBusinessName("Sky Lounge");
//        busy11.setIsDefault(true);
//        busy11.setBusinessId("SKYL");
//        busy11.setNumberOfScreens(1);
//        busy11.setPhoneContact("256790790491");
//
//        busy12 = new AdBusiness();
//        busy12.setBusinessName("Bistro Restaurant");
//        busy12.setIsDefault(true);
//        busy12.setBusinessId("BIST");
//        busy12.setNumberOfScreens(1);
//        busy12.setPhoneContact("256790790491");
//
//        busy13 = new AdBusiness();
//        busy13.setBusinessName("Protea Hotel");
//        busy13.setIsDefault(true);
//        busy13.setBusinessId("PROT");
//        busy13.setNumberOfScreens(1);
//        busy13.setPhoneContact("256790790491");
//
//        busy14 = new AdBusiness();
//        busy14.setBusinessName("Prunes Restaurant");
//        busy14.setIsDefault(true);
//        busy14.setBusinessId("PRUN");
//        busy14.setNumberOfScreens(1);
//        busy14.setPhoneContact("256790790491");
//
//        busy15 = new AdBusiness();
//        busy15.setBusinessName("UNHCR canteen");
//        busy15.setIsDefault(true);
//        busy15.setBusinessId("UNHC");
//        busy15.setNumberOfScreens(1);
//        busy15.setPhoneContact("256790790491");
//
//        busy16 = new AdBusiness();
//        busy16.setBusinessName("Big Mike's Café");
//        busy16.setIsDefault(true);
//        busy16.setBusinessId("BMIK");
//        busy16.setNumberOfScreens(1);
//        busy16.setPhoneContact("256790790491");
//
//        busy17 = new AdBusiness();
//        busy17.setBusinessName("The Lawns Restaurant");
//        busy17.setIsDefault(true);
//        busy17.setBusinessId("LAWN");
//        busy17.setNumberOfScreens(1);
//        busy17.setPhoneContact("256790790491");
//
//        busy18 = new AdBusiness();
//        busy18.setBusinessName("White Rose Restaurant");
//        busy18.setIsDefault(true);
//        busy18.setBusinessId("WIRO");
//        busy18.setNumberOfScreens(1);
//        busy18.setPhoneContact("256790790491");
//
//        busy19 = new AdBusiness();
//        busy19.setBusinessName("University Hall");
//        busy19.setIsDefault(true);
//        busy19.setBusinessId("UHAL");
//        busy19.setNumberOfScreens(1);
//        busy19.setPhoneContact("256790790491");
//
//        busy20 = new AdBusiness();
//        busy20.setBusinessName("Tuskys");
//        busy20.setIsDefault(true);
//        busy20.setBusinessId("TUSK");
//        busy20.setNumberOfScreens(1);
//        busy20.setPhoneContact("256790790491");
//
//        busy21 = new AdBusiness();
//        busy21.setBusinessName("MUK Guest House");
//        busy21.setIsDefault(true);
//        busy21.setBusinessId("MUKG");
//        busy21.setNumberOfScreens(1);
//        busy21.setPhoneContact("256790790491");
//
//        busy22 = new AdBusiness();
//        busy22.setBusinessName("Game shopping mall");
//        busy22.setIsDefault(true);
//        busy22.setBusinessId("GAME");
//        busy22.setNumberOfScreens(1);
//        busy22.setPhoneContact("256790790491");
//
//        busy23 = new AdBusiness();
//        busy23.setBusinessName("Stanley Hall");
//        busy23.setIsDefault(true);
//        busy23.setBusinessId("STAH");
//        busy23.setNumberOfScreens(1);
//        busy23.setPhoneContact("256790790491");
//
//        busy24 = new AdBusiness();
//        busy24.setBusinessName("Barclays Bank");
//        busy24.setIsDefault(true);
//        busy24.setBusinessId("BARC");
//        busy24.setNumberOfScreens(1);
//        busy24.setPhoneContact("256790790491");
//
//        busy26 = new AdBusiness();
//        busy26.setBusinessName("Quality Foods Mall");
//        busy26.setIsDefault(true);
//        busy26.setBusinessId("QFUD");
//        busy26.setNumberOfScreens(1);
//        busy26.setPhoneContact("256790790491");
//
//        busy27 = new AdBusiness();
//        busy27.setBusinessName("Cayenne Club");
//        busy27.setIsDefault(true);
//        busy27.setBusinessId("CYNN");
//        busy27.setNumberOfScreens(1);
//        busy27.setPhoneContact("256790790491");
//
//        busy29 = new AdBusiness();
//        busy29.setBusinessName("Friecca Pharmacy");
//        busy29.setIsDefault(true);
//        busy29.setBusinessId("FRIC");
//        busy29.setNumberOfScreens(1);
//        busy29.setPhoneContact("256790790491");
//
//        busy30 = new AdBusiness();
//        busy30.setBusinessName("Superbets");
//        busy30.setIsDefault(true);
//        busy30.setBusinessId("SUPA");
//        busy30.setNumberOfScreens(1);
//        busy30.setPhoneContact("256790790491");
//
//        busy31 = new AdBusiness();
//        busy31.setBusinessName("Bill's Cinema");
//        busy31.setIsDefault(true);
//        busy31.setBusinessId("BILZ");
//        busy31.setNumberOfScreens(1);
//        busy31.setPhoneContact("256790790491");
//
//        busy32 = new AdBusiness();
//        busy32.setBusinessName("Travellers' Restaurant");
//        busy32.setIsDefault(true);
//        busy32.setBusinessId("TRVL");
//        busy32.setNumberOfScreens(1);
//        busy32.setPhoneContact("256790790491");
//
//        busy33 = new AdBusiness();
//        busy33.setBusinessName("St Andrew's Hostel");
//        busy33.setIsDefault(true);
//        busy33.setBusinessId("SAND");
//        busy33.setNumberOfScreens(1);
//        busy33.setPhoneContact("256790790491");
//
//        busy34 = new AdBusiness();
//        busy34.setBusinessName("Superbets");
//        busy34.setIsDefault(true);
//        busy34.setBusinessId("SUPB");
//        busy34.setNumberOfScreens(1);
//        busy34.setPhoneContact("256790790491");
//
//        busy35 = new AdBusiness();
//        busy35.setBusinessName("2K Restaurant");
//        busy35.setIsDefault(true);
//        busy35.setBusinessId("TWOK");
//        busy35.setNumberOfScreens(1);
//        busy35.setPhoneContact("256790790491");
//
//        busy36 = new AdBusiness();
//        busy36.setPhoneContact("256790790491");
//        busy36.setBusinessName("Staff Canteen");
//        busy36.setIsDefault(true);
//        busy36.setBusinessId("SMUK");
//        busy36.setNumberOfScreens(1);
//        busy36.setPhoneContact("256790790491");
//
//        busy37 = new AdBusiness();
//        busy37.setBusinessName("Kampala Medical Chambers");
//        busy37.setIsDefault(true);
//        busy37.setBusinessId("KPMC");
//        busy37.setNumberOfScreens(1);
//        busy37.setPhoneContact("256790790491");
//
//        busy38 = new AdBusiness();
//        busy38.setBusinessName("Fortune Bets");
//        busy38.setIsDefault(true);
//        busy38.setBusinessId("FORT");
//        busy38.setNumberOfScreens(1);
//        busy38.setPhoneContact("256790790491");
//
//        busy39 = new AdBusiness();
//        busy39.setBusinessName("Galz Betting");
//        busy39.setIsDefault(true);
//        busy39.setBusinessId("GALZ");
//        busy39.setNumberOfScreens(1);
//        busy39.setPhoneContact("256790790491");
//
//        busy40 = new AdBusiness();
//        busy40.setBusinessName("Koko Bar");
//        busy40.setIsDefault(true);
//        busy40.setBusinessId("KOKO");
//        busy40.setNumberOfScreens(1);
//        busy40.setPhoneContact("256790790491");
//
//        busy41 = new AdBusiness();
//        busy41.setBusinessName("Hotel Inter-Tropix");
//        busy41.setIsDefault(true);
//        busy41.setBusinessId("HITX");
//        busy41.setNumberOfScreens(1);
//        busy41.setPhoneContact("256790790491");
//
//        busy42 = new AdBusiness();
//        busy42.setBusinessName("Source of the Nile Hotel");
//        busy42.setIsDefault(true);
//        busy42.setBusinessId("SOTN");
//        busy42.setNumberOfScreens(1);
//        busy42.setPhoneContact("256790790491");
//
//        busy43 = new AdBusiness();
//        busy43.setBusinessName("Benrich");
//        busy43.setIsDefault(true);
//        busy43.setBusinessId("BRICH");
//        busy43.setNumberOfScreens(1);
//        busy43.setPhoneContact("256790790491");
//
//        busy44 = new AdBusiness();
//        busy44.setBusinessName("The 500");
//        busy44.setIsDefault(true);
//        busy44.setBusinessId("DAFV");
//        busy44.setNumberOfScreens(1);
//        busy44.setPhoneContact("256790790491");
//
//        busy45 = new AdBusiness();
//        busy45.setBusinessName("Mugiez");
//        busy45.setIsDefault(true);
//        busy45.setBusinessId("MUGZ");
//        busy45.setNumberOfScreens(1);
//        busy45.setPhoneContact("256790790491");
//
//        busy46 = new AdBusiness();
//        busy46.setBusinessName("Watoto");
//        busy46.setIsDefault(true);
//        busy46.setBusinessId("WATO");
//        busy46.setNumberOfScreens(1);
//        busy46.setPhoneContact("256790790491");
//
//        busy47 = new AdBusiness();
//        busy47.setBusinessName("Style and Smile Saloon");
//        busy47.setIsDefault(true);
//        busy47.setBusinessId("SASS");
//        busy47.setNumberOfScreens(1);
//        busy47.setPhoneContact("256790790491");
//
//        testBusinesses.add(busy1);
//        testBusinesses.add(busy2);
//        testBusinesses.add(busy3);
//        testBusinesses.add(busy4);
//        testBusinesses.add(busy5);
//        testBusinesses.add(busy6);
//        testBusinesses.add(busy7);
//        testBusinesses.add(busy8);
//        testBusinesses.add(busy9);
//        testBusinesses.add(busy10);
//        testBusinesses.add(busy11);
//        testBusinesses.add(busy12);
//        testBusinesses.add(busy13);
//        testBusinesses.add(busy14);
//        testBusinesses.add(busy15);
//        testBusinesses.add(busy16);
//        testBusinesses.add(busy17);
//        testBusinesses.add(busy18);
//        testBusinesses.add(busy19);
//        testBusinesses.add(busy20);
//        testBusinesses.add(busy21);
//        testBusinesses.add(busy22);
//        testBusinesses.add(busy23);
//        testBusinesses.add(busy24);
//        testBusinesses.add(busy26);
//        testBusinesses.add(busy27);
//        testBusinesses.add(busy29);
//        testBusinesses.add(busy30);
//        testBusinesses.add(busy31);
//        testBusinesses.add(busy32);
//        testBusinesses.add(busy33);
//        testBusinesses.add(busy34);
//        testBusinesses.add(busy35);
//        testBusinesses.add(busy36);
//        testBusinesses.add(busy37);
//        testBusinesses.add(busy38);
//        testBusinesses.add(busy39);
//        testBusinesses.add(busy40);
//        testBusinesses.add(busy41);
//        testBusinesses.add(busy42);
//        testBusinesses.add(busy43);
//        testBusinesses.add(busy44);
//        testBusinesses.add(busy45);
//        testBusinesses.add(busy46);
//        testBusinesses.add(busy47);
//
//        customHibernate.saveBulk(testBusinesses);
//    }
//
//    /**
//     * Add a terminal You can later add a screen and link it to this terminal or
//     * vice-versa
//     *
//     * @param taskX
//     * @param taskY
//     * @param taskZ
//     * @param terminalId
//     * @param terminalName
//     * @param terminalDesc
//     * @param latitude
//     * @param longitude
//     * @return
//     * @throws com.library.customexception.MyCustomException
//     */
//    public AdTerminal addTerminal( //can be done independently of screen addition
//            int taskX,
//            int taskY,
//            int taskZ,
//            String terminalId,
//            String terminalName,
//            String terminalDesc,
//            double latitude,
//            double longitude
//    ) throws MyCustomException {
//
//        //PROD
//        //int taskX = 1493101974;
//        //int taskY = 1493101989;
//        //int taskZ = 1504714261;
//        AdTerminal terminal = new AdTerminal();
//        terminal.setLatitude(latitude);
//        terminal.setLongitude(longitude);
//        terminal.setTerminalId(terminalId);
//        terminal.setTerminalName(terminalName);
//        terminal.setTerminalDescription(terminalDesc);
//        terminal.setTaskIdX(taskX);
//        terminal.setTaskIdY(taskY);
//        terminal.setTaskIdZ(taskZ);
//
//        customHibernate.saveEntity(terminal);
//
//        return terminal;
//
//    }
//
//    /**
//     * Add a production screen
//     *
//     * @param vendorName
//     * @param screenHeight
//     * @param screenWidth
//     * @param screenSize
//     * @param screenType
//     * @param audienceCount
//     * @param audienceTypes
//     * @param businessTypes
//     * @param screenValue
//     * @param screenArea
//     * @param screenOwner
//     * @param extra1
//     * @param extra2
//     * @param extra3
//     * @param extra4
//     * @param isPublishScreen
//     * @param terminal
//     * @throws MyCustomException
//     */
//    public void addScreen(
//            String vendorName,
//            int screenHeight,
//            int screenWidth,
//            ScreenSize screenSize,
//            AdScreenType screenType,
//            int audienceCount,
//            Set<AdAudienceType> audienceTypes,
//            Set<AdBusinessType> businessTypes,
//            float screenValue,
//            AdArea screenArea,
//            AdBusiness screenOwner,
//            String extra1,
//            String extra2,
//            String extra3,
//            String extra4,
//            boolean isPublishScreen,
//            AdTerminal terminal
//    ) throws MyCustomException {
//
//        Set<AdAudienceType> audienceTypes = new HashSet<>();
//        audienceTypes.add(aud8);
//        audienceTypes.add(aud10);
//        audienceTypes.add(aud12);
//        Set<AdBusinessType> businessTypes = new HashSet<>();
//        businessTypes.add(bus1);
//        businessTypes.add(bus3);
//
//        String screenId = generateScreenId(screenOwner.getBusinessId());
//
//        AdScreen screen = new AdScreen();
//        screen.setAudienceCount(audienceCount);
//        screen.setDisplayHeight(screenHeight);
//        screen.setDisplayWidth(screenWidth);
//        screen.setScreenId(screenId);
//        screen.setScreenSize(screenSize);
//        screen.setScreenType(screenType);
//        screen.setSupportTerminal(terminal);
//        screen.setVendorName(vendorName);
//        screen.setAdBusiness(screenOwner); //get business name from here for GET_SCREENS
//        screen.setScreenValue(screenValue); //determined by number of screens connected, audience, location, size, etc
//        screen.getBusinessTypes().addAll(businessTypes);
//        screen.getAudienceTypes().addAll(audienceTypes);
//        screen.setScreenArea(screenArea);
//        screen.setExtra1(extra1);//like a building housing the business
//        screen.setExtra2(extra2); //e.g. where exactly the screen is located
//        screen.setExtra3(extra3); //ignore for now i guess
//        screen.setExtra4(extra4);//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen.setIsPublishScreen(isPublishScreen);
//
//        customHibernate.saveOrUpdateEntity(screen);
//    }
//
//    /**
//     * Add Test screens
//     *
//     * @param terminal
//     * @throws com.library.customexception.MyCustomException
//     */
//    public void addTestScreens(AdTerminal terminal) throws MyCustomException {
//
//        int screenHeight = 1080;
//        int screenWidth = 1920;
//
//        AdScreen screen1 = new AdScreen();
//        screen1.setAudienceCount(30);
//        screen1.setDisplayHeight(screenHeight);
//        screen1.setDisplayWidth(screenWidth);
//        screen1.setScreenId(generateScreenId(busy1.getBusinessId()));
//        screen1.setScreenSize(ScreenSize.THIRTYTWO);
//        screen1.setScreenType(AdScreenType.FLAT_LCD_TV);
//        screen1.setSupportTerminal(terminal);
//        screen1.setVendorName("HiSense");
//        screen1.setAdBusiness(busy1); //get business name from here for GET_SCREENS
//        screen1.setScreenValue(1.200f); //determined by number of screens connected, audience, location, size, etc
//        screen1.getBusinessTypes().add(bus12);
//        screen1.getBusinessTypes().add(bus4);
//        screen1.getAudienceTypes().add(aud1);
//        screen1.getAudienceTypes().add(aud2);
//        screen1.getAudienceTypes().add(aud4);
//        screen1.getAudienceTypes().add(aud5);
//        screen1.setScreenArea(area1);
//        screen1.setExtra1("Village Mall");//like a building housing the business
//        screen1.setExtra2("lounge"); //e.g. where exactly the screen is located
//        screen1.setExtra3(""); //ignore for now i guess
//        screen1.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen1.setIsPublishScreen(Boolean.TRUE); //Show screen on user UI
//
//        AdScreen screen2 = new AdScreen();
//        screen2.setAudienceCount(10);
//        screen2.setDisplayHeight(screenHeight);
//        screen2.setDisplayWidth(screenWidth);
//        screen2.setScreenSize(ScreenSize.FOURTY);
//        screen2.setScreenType(AdScreenType.FLAT_LCD_TV);
//        screen2.setSupportTerminal(terminal);
//        screen2.setVendorName("LG");
//        screen2.setScreenId(generateScreenId(busy2.getBusinessId()));
//        screen2.setAdBusiness(busy2); //get business name from here for GET_SCREENS
//        screen2.setScreenValue(1.125f); //determined by number of screens connected, audience, location, size, etc
//        screen2.getBusinessTypes().add(bus1);
//        screen2.getBusinessTypes().add(bus5);
//        screen2.getAudienceTypes().add(aud4);
//        screen2.getAudienceTypes().add(aud3);
//        screen2.getAudienceTypes().add(aud2);
//        screen2.getAudienceTypes().add(aud6);
//        screen2.setScreenArea(area1);
//        screen2.setExtra1(""); //like a building, road housing the business
//        screen2.setExtra2("counter");//e.g. where exactly the screen is located
//        screen2.setExtra3(""); //ignore for now i guess
//        screen2.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen2.setIsPublishScreen(Boolean.TRUE); //Show screen on user UI
//
//        AdScreen screen3 = new AdScreen();
//        screen3.setAudienceCount(40);
//        screen3.setDisplayHeight(screenHeight);
//        screen3.setDisplayWidth(screenWidth);
//        screen3.setScreenId(generateScreenId(busy3.getBusinessId()));
//        screen3.setScreenSize(ScreenSize.THIRTYTWO);
//        screen3.setScreenType(AdScreenType.FLAT_LCD_TV);
//        screen3.setSupportTerminal(terminal);
//        screen3.setVendorName("Panasonic");
//        screen3.setAdBusiness(busy3); //get business name from here for GET_SCREENS
//        screen3.setScreenValue(1.275f); //determined by number of screens connected, audience, location, size, etc
//        screen3.getBusinessTypes().add(bus12);
//        screen3.getBusinessTypes().add(bus5);
//        screen3.getAudienceTypes().add(aud2);
//        screen3.getAudienceTypes().add(aud9);
//        screen3.getAudienceTypes().add(aud1);
//        screen3.getAudienceTypes().add(aud4);
//        screen3.getAudienceTypes().add(aud5);
//        screen3.setScreenArea(area1);
//        screen3.setExtra1("Village Mall");//like a building, road housing the business
//        screen3.setExtra2("entrance"); //e.g. where exactly the screen is located
//        screen3.setExtra3(""); //ignore for now i guess
//        screen3.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen3.setIsPublishScreen(Boolean.TRUE); //Show screen on user UI
//
//        AdScreen screen4 = new AdScreen();
//        screen4.setAudienceCount(20);
//        screen4.setDisplayHeight(screenHeight);
//        screen4.setDisplayWidth(screenWidth);
//        screen4.setScreenId(generateScreenId(busy4.getBusinessId()));
//        screen4.setScreenSize(ScreenSize.FIFTYTWO);
//        screen4.setScreenType(AdScreenType.FLAT_LED_TV);
//        screen4.setSupportTerminal(terminal);
//        screen4.setVendorName("Sony");
//        screen4.setAdBusiness(busy4); //get business name from here for GET_SCREENS
//        screen4.setScreenValue(1.325f); //determined by number of screens connected, audience, location, size, etc
//        screen4.getBusinessTypes().add(bus3);
//        screen4.getBusinessTypes().add(bus7);
//        screen4.getAudienceTypes().add(aud4);
//        screen4.getAudienceTypes().add(aud10);
//        screen4.getAudienceTypes().add(aud7);
//        screen4.getAudienceTypes().add(aud5);
//        screen4.setScreenArea(area2);
//        screen4.setExtra1("");//like a building, road housing the business
//        screen4.setExtra2("main screen"); //e.g. where exactly the screen is located
//        screen4.setExtra3(""); //ignore for now i guess
//        screen4.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen4.setIsPublishScreen(Boolean.TRUE); //Show screen on user UI
//
//        AdScreen screen5 = new AdScreen();
//        screen5.setAudienceCount(15);
//        screen5.setDisplayHeight(screenHeight);
//        screen5.setDisplayWidth(screenWidth);
//        screen5.setScreenId(generateScreenId(busy5.getBusinessId()));
//        screen5.setScreenSize(ScreenSize.THIRTYTWO);
//        screen5.setScreenType(AdScreenType.FLAT_LED_TV);
//        screen5.setSupportTerminal(terminal);
//        screen5.setVendorName("Samsung");
//        screen5.setAdBusiness(busy5); //get business name from here for GET_SCREENS
//        screen5.setScreenValue(1.100f); //determined by number of screens connected, audience, location, size, etc
//        screen5.getBusinessTypes().add(bus6);
//        screen5.getBusinessTypes().add(bus8);
//        screen5.getAudienceTypes().add(aud8);
//        screen5.getAudienceTypes().add(aud4);
//        screen5.getAudienceTypes().add(aud5);
//        screen5.setScreenArea(area3);
//        screen5.setExtra1("Bombo Rd");//like a building, road housing the business
//        screen5.setExtra2("reception"); //e.g. where exactly the screen is located
//        screen5.setExtra3(""); //ignore for now i guess
//        screen5.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen5.setIsPublishScreen(Boolean.TRUE); //Show screen on user UI
//
//        AdScreen screen6 = new AdScreen();
//        screen6.setAudienceCount(17);
//        screen6.setDisplayHeight(screenHeight);
//        screen6.setDisplayWidth(screenWidth);
//        screen6.setScreenId(generateScreenId(busy6.getBusinessId()));
//        screen6.setScreenSize(ScreenSize.FOURTY);
//        screen6.setScreenType(AdScreenType.FLAT_LED_TV);
//        screen6.setSupportTerminal(terminal);
//        screen6.setVendorName("Samsung");
//        screen6.setAdBusiness(busy6); //get business name from here for GET_SCREENS
//        screen6.setScreenValue(1.200f); //determined by number of screens connected, audience, location, size, etc
//        screen6.getBusinessTypes().add(bus14);
//        screen6.getBusinessTypes().add(bus13);
//        screen6.getAudienceTypes().add(aud9);
//        screen6.getAudienceTypes().add(aud8);
//        screen6.getAudienceTypes().add(aud5);
//        screen6.setScreenArea(area3);
//        screen6.setExtra1("Kla Rd");//like a building, road housing the business
//        screen6.setExtra2("reception"); //e.g. where exactly the screen is located
//        screen6.setExtra3(""); //ignore for now i guess
//        screen6.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen6.setIsPublishScreen(Boolean.TRUE); //Show screen on user UI
//
//        AdScreen screen7 = new AdScreen();
//        screen7.setAudienceCount(21);
//        screen7.setDisplayHeight(screenHeight);
//        screen7.setDisplayWidth(screenWidth);
//        screen7.setScreenId(generateScreenId(busy7.getBusinessId()));
//        screen7.setScreenSize(ScreenSize.FIFTYTWO);
//        screen7.setScreenType(AdScreenType.FLAT_LED_TV);
//        screen7.setSupportTerminal(terminal);
//        screen7.setVendorName("Samsung");
//        screen7.setAdBusiness(busy7); //get business name from here for GET_SCREENS
//        screen7.setScreenValue(1.300f); //determined by number of screens connected, audience, location, size, etc
//        screen7.getBusinessTypes().add(bus15);
//        screen7.getBusinessTypes().add(bus14);
//        screen7.getAudienceTypes().add(aud9);
//        screen7.getAudienceTypes().add(aud8);
//        screen7.getAudienceTypes().add(aud2);
//        screen7.setScreenArea(area3);
//        screen7.setExtra1("Bombo Rd");//like a building, road housing the business
//        screen7.setExtra2("reception"); //e.g. where exactly the screen is located
//        screen7.setExtra3(""); //ignore for now I guess
//        screen7.setExtra4("");//get from AdBusinessType  -> getAdBusinessTypeShortName();
//        screen7.setIsPublishScreen(Boolean.TRUE);
//
//        adScreens.add(screen1);
//        adScreens.add(screen2);
//        adScreens.add(screen3);
//        adScreens.add(screen4);
//        adScreens.add(screen5);
//        adScreens.add(screen6);
//        adScreens.add(screen7);
//
//        customHibernate.saveBulk(adScreens);
//    }
//
//    /**
//     * Create a guest user, who will be used for Guest Logins. This user must me
//     * created in order for guest logins to work
//     *
//     * @throws MyCustomException
//     */
//    public void addGuestUser() throws MyCustomException {
//
//        String userId = NamedConstants.GUEST_USER_ID;
//        String password = NamedConstants.GUEST_USER_PASSWORD;
//
//        guestUser = new AdUser();
//        guestUser.setAccountStatus(AdXpoAccountStatus.ACTIVE);
//        guestUser.setAgreedToTermsOfuse(Boolean.TRUE);
//        guestUser.setFirstName("Guest");
//        guestUser.setPrimaryPhone(userId);
//        guestUser.setPassword(Security.createHash(password));
//        guestUser.setUserId(userId);
//        guestUser.setIsPasswordEncrypted(Boolean.TRUE);
//        guestUser.setFailedLoginAttempts(0);
//        //adUser.setUserId(GeneralUtils.generateUserId(primaryPhone));
//
//        customHibernate.saveEntity(guestUser);
//    }
//
//    /**
//     * User will be both a testAdClient and a screen owner
//     *
//     * @throws com.library.customexception.MyCustomException
//     */
//    public void addTestUser() throws MyCustomException {
//
//        String userId = NamedConstants.TEST_USER_ID;
//        String password = NamedConstants.TEST_USER_PASSWORD;
//
//        testUser = new AdUser();
//        testUser.setAccountStatus(AdXpoAccountStatus.ACTIVE);
//        testUser.setAgreedToTermsOfuse(Boolean.TRUE);
//        testUser.setFirstName("Test");
//        testUser.setPrimaryPhone(userId);
//        testUser.setPassword(Security.createHash(password));
//        testUser.setUserId(userId);
//        testUser.setIsPasswordEncrypted(Boolean.TRUE);
//        guestUser.setFailedLoginAttempts(0);
//        //adUser.setUserId(GeneralUtils.generateUserId(primaryPhone));
//
//        customHibernate.saveEntity(testUser);
//
//    }
//
//    /**
//     *
//     * @return @throws MyCustomException
//     */
//    private boolean screenLayoutsInitialised() throws MyCustomException {
//
//        int count = customHibernate.countRows(AdScreenLayout.class, null).intValue();
//
//        if (count > 0) {
//            return Boolean.TRUE;
//        }
//
//        return Boolean.FALSE;
//
//    }
//
//    /**
//     * User will be both a testAdClient and a screen owner
//     *
//     * @throws com.library.customexception.MyCustomException
//     */
//    public void addTemplateCampaignsUser() throws MyCustomException {
//
//        String userId = NamedConstants.TEMPLATE_CAMPAIGNS_USER_ID;
//        String password = NamedConstants.TEMPLATE_CAMPAIGNS_USER_PASSWORD;
//
//        templatesCampaignUser = new AdUser();
//        templatesCampaignUser.setAccountStatus(AdXpoAccountStatus.ACTIVE);
//        templatesCampaignUser.setAgreedToTermsOfuse(Boolean.TRUE);
//        templatesCampaignUser.setFirstName("Templates User");
//        templatesCampaignUser.setPrimaryPhone(userId);
//        templatesCampaignUser.setPassword(Security.createHash(password));
//        templatesCampaignUser.setUserId(userId);
//        templatesCampaignUser.setIsPasswordEncrypted(Boolean.TRUE);
//        guestUser.setFailedLoginAttempts(0);
//        //adUser.setUserId(GeneralUtils.generateUserId(primaryPhone));
//
//        customHibernate.saveEntity(templatesCampaignUser);
//
//    }
//
//    /**
//     * Update user password
//     *
//     * @param userId
//     * @param oldPassword
//     * @param newPassword
//     * @throws MyCustomException
//     */
//    public void updateUserPassword(String userId, String oldPassword, String newPassword) throws MyCustomException {
//
//        Map<String, Set<Object>> fetchProps = new HashMap<>();
//        //fetchProps.put("password", new HashSet<>(Arrays.asList((Object) oldPassword)));
//        fetchProps.put("userId", new HashSet<>(Arrays.asList((Object) userId)));
//
//        AdUser user = customHibernate.fetchEntity(AdUser.class, fetchProps);
//
//        //validate old password first
//        String hashedPasswordFromDB = user.getPassword();
//        Security.validatePassword(oldPassword, hashedPasswordFromDB);
//
//        user.setPassword(Security.createHash(newPassword));
//        customHibernate.updateEntity(user);
//
//    }
//
//    /**
//     * Update user password
//     *
//     * @param oldUserId
//     * @param newUserId
//     * @param password
//     * @throws MyCustomException
//     */ //has issues - error -> Cannot delete or update a parent row: a foreign key constraint fails 
//    //(`adexpo_main`.`ad_client`, CONSTRAINT `FK_d6m1lbjx8rop1yg0xiukmbhro` FOREIGN KEY (`user_id`) REFERENCES `ad_user` (`user_id`))
//    public void updateUserId(String oldUserId, String newUserId, String password) throws MyCustomException {
//
//        Map<String, Set<Object>> fetchProps = new HashMap<>();
//        //fetchProps.put("password", new HashSet<>(Arrays.asList((Object) password)));
//        fetchProps.put("userId", new HashSet<>(Arrays.asList((Object) oldUserId)));
//
//        AdUser user = customHibernate.fetchEntity(AdUser.class, fetchProps);
//
//        //validate old password first
//        String hashedPasswordFromDB = user.getPassword();
//        Security.validatePassword(password, hashedPasswordFromDB);
//
//        user.setUserId(newUserId);
//        customHibernate.updateEntity(user);
//
//    }
//
//    /**
//     * This screen owner will own all the test screens we have
//     *
//     * @throws com.library.customexception.MyCustomException
//     */
//    public void addTestScreenOwner() throws MyCustomException {
//
//        testScreenOwner = new AdScreenOwner();
//        testScreenOwner.getBusinesses().addAll(testBusinesses);
//        testScreenOwner.setAdUser(testUser);
//
//        customHibernate.saveEntity(testScreenOwner);
//
//    }
//
//    /**
//     *
//     * @throws MyCustomException
//     */
//    public void addTestCampaignClient() throws MyCustomException {
//
//        testAdClient = new AdClient();
//        testAdClient.setAdUser(this.testUser);
//        testAdClient.setIsToBeCensored(Boolean.TRUE);
//        testAdClient.setNumberOfPrograms(0);
//
//        customHibernate.saveEntity(testAdClient);
//    }
//
//    /**
//     *
//     * @throws MyCustomException
//     */
//    public void addGuestCampaignClient() throws MyCustomException {
//
//        guestAdClient = new AdClient();
//        guestAdClient.setAdUser(this.guestUser);
//        guestAdClient.setIsToBeCensored(Boolean.TRUE);
//        guestAdClient.setNumberOfPrograms(0);
//
//        customHibernate.saveEntity(guestAdClient);
//    }
//
//    /**
//     *
//     * @throws MyCustomException
//     */
//    public void addTemplateCampaignClient() throws MyCustomException {
//
//        templatesCampaignClient = new AdClient();
//        templatesCampaignClient.setAdUser(this.templatesCampaignUser);
//        templatesCampaignClient.setIsToBeCensored(Boolean.TRUE);
//        templatesCampaignClient.setNumberOfPrograms(0);
//
//        customHibernate.saveEntity(templatesCampaignClient);
//    }
//
//    public void addScreenSizes() throws MyCustomException {
//
//        Set<AdScreenSize> screensizes = new HashSet<>();
//
//        AdScreenSize fifteen = new AdScreenSize();
//        fifteen.setScreenSizeCode("FIFTEEN");
//        fifteen.setScreenSizeName("15 INCH");
//        fifteen.setScreenSizeValue(1.000f);
//
//        AdScreenSize nineteen = new AdScreenSize();
//        nineteen.setScreenSizeCode("NINETEEN");
//        nineteen.setScreenSizeName("19 INCH");
//        nineteen.setScreenSizeValue(1.100f);
//
//        AdScreenSize twentyOne = new AdScreenSize();
//        twentyOne.setScreenSizeCode("TWENTYONE");
//        twentyOne.setScreenSizeName("21 INCH");
//        twentyOne.setScreenSizeValue(1.125f);
//
//        AdScreenSize twentyNine = new AdScreenSize();
//        twentyNine.setScreenSizeCode("TWENTYNINE");
//        twentyNine.setScreenSizeName("29 INCH");
//        twentyNine.setScreenSizeValue(1.150f);
//
//        AdScreenSize thirtyTwo = new AdScreenSize();
//        thirtyTwo.setScreenSizeCode("THIRTYTWO");
//        thirtyTwo.setScreenSizeName("32 INCH");
//        thirtyTwo.setScreenSizeValue(1.175f);
//
//        AdScreenSize fourty = new AdScreenSize();
//        fourty.setScreenSizeCode("FOURTY");
//        fourty.setScreenSizeName("40 INCH");
//        fourty.setScreenSizeValue(1.200f);
//
//        AdScreenSize fiftyTwo = new AdScreenSize();
//        fiftyTwo.setScreenSizeCode("FIFTYTWO");
//        fiftyTwo.setScreenSizeName("52 INCH");
//        fiftyTwo.setScreenSizeValue(1.250f);
//
//        screensizes.add(fifteen);
//        screensizes.add(nineteen);
//        screensizes.add(twentyOne);
//        screensizes.add(twentyNine);
//        screensizes.add(thirtyTwo);
//        screensizes.add(fourty);
//        screensizes.add(fiftyTwo);
//
//        customHibernate.saveBulk(screensizes);
//    }
//
//    /**
//     * Add available screen layouts to the system
//     *
//     * @throws MyCustomException
//     */
//    public void addDisplayLayouts() throws MyCustomException {
//
//        Set<AdScreenLayout> screenLayouts = new HashSet<>();
//
//        //FULLSCREEN
//        AdScreenLayout fullScreenLayout = new AdScreenLayout();
//        fullScreenLayout.setLayoutId(ScreenSplit.FULL_SCREEN.getValue());
//        fullScreenLayout.setLayoutName("Full-Screen only layout");
//        fullScreenLayout.setLayoutValue(1.500f);
//
//        //FULLSCREEN-TEXT
//        AdScreenLayout fullScreenTextLayout = new AdScreenLayout();
//        fullScreenTextLayout.setLayoutId(ScreenSplit.FULLSCREEN_TEXT.getValue());
//        fullScreenTextLayout.setLayoutName("Full-Screen and Text layout");
//        fullScreenTextLayout.setLayoutValue(1.750f);
//
//        //3SPLIT
//        AdScreenLayout threeScreenSplit = new AdScreenLayout();
//        threeScreenSplit.setLayoutId(ScreenSplit.THREE_SPLIT.getValue());
//        threeScreenSplit.setLayoutName("3-Screen split layout");
//        threeScreenSplit.setLayoutValue(1.300f);
//
//        //2SPLIT
//        AdScreenLayout twoScreenSplit = new AdScreenLayout();
//        twoScreenSplit.setLayoutId(ScreenSplit.TWO_SPLIT.getValue());
//        twoScreenSplit.setLayoutName("2-Screen split layout");
//        twoScreenSplit.setLayoutValue(1.200f);
//
//        //TEXT
//        AdScreenLayout textOnlyLayout = new AdScreenLayout();
//        textOnlyLayout.setLayoutId(ScreenSplit.TEXT_ONLY.getValue());
//        textOnlyLayout.setLayoutName("Text-Only layout");
//        textOnlyLayout.setLayoutValue(1.000f);
//
//        //UNKNOWN
//        AdScreenLayout unKnownLayout = new AdScreenLayout();
//        unKnownLayout.setLayoutId(ScreenSplit.UNKNOWN.getValue());
//        unKnownLayout.setLayoutName("Unknown layout");
//        unKnownLayout.setLayoutValue(1.000f);
//        unKnownLayout.setDescription("This will be the default layout used especially if there is no layout chosen. It can be anything");
//
//        screenLayouts.add(twoScreenSplit);
//        screenLayouts.add(threeScreenSplit);
//        screenLayouts.add(fullScreenLayout);
//        screenLayouts.add(textOnlyLayout);
//        screenLayouts.add(fullScreenTextLayout);
//        screenLayouts.add(unKnownLayout);
//
//        customHibernate.saveBulk(screenLayouts);
//
//    }
//
//    /**
//     * The available time slots for campaigns e.g. PRIME (prime time)
//     *
//     * @throws MyCustomException
//     */
//    public void addTimeSlots() throws MyCustomException {
//
//        /*
//            INSTANT (now @5000/-) | LATENIGHT (12am - 3.59am @500/-) | FREEBIE (4am - 5.59am @0/-)| EARLY (6am-11.59am @700/-) | LUNCH (12pm-4.59pm @1,000/-) | RUSHHOUR (5pm-7.59pm @1200/-) | PRIME (8pm-10.59pm @1500/-)  
//         */
//        Set<AdTimeSlot> timeSlots = new HashSet<>();
//
//        Amounttype slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(700);
//
//        //INSTANT - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(3000);
//        AdTimeSlot timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(0, 0));
//        timeSlot.setEndTime(new LocalTime(0, 0));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("INSTANT");
//        timeSlot.setTimeSlotName("Instant Ad");
//        timeSlot.setTimeSlotDescription("Dont wait in a queue, play your advert now!");
//        timeSlot.setIsInstant(Boolean.TRUE);
//        timeSlot.setSlotDiscount(0.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(10).getMillis());
//        timeSlots.add(timeSlot);
//
//        //LATENIGHT - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(500);
//        timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(23, 0));
//        timeSlot.setEndTime(new LocalTime(3, 59));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("LATENITE");
//        timeSlot.setTimeSlotName("Late Night");
//        timeSlot.setTimeSlotDescription("Late in the wee hours of the night, for clubbers and other 'nocturnals' ");
//        timeSlot.setIsInstant(Boolean.FALSE);
//        timeSlot.setSlotDiscount(0.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
//        timeSlots.add(timeSlot);
//
//        //FREEBIE - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(0);
//        timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(4, 0));
//        timeSlot.setEndTime(new LocalTime(5, 59));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("FREEBIE");
//        timeSlot.setTimeSlotName("Free Ads");
//        timeSlot.setTimeSlotDescription("2 hours of free advertising");
//        timeSlot.setIsInstant(Boolean.FALSE);
//        timeSlot.setSlotDiscount(100.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
//        timeSlots.add(timeSlot);
//
//        //EARLY - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(700);
//        timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(6, 0));
//        timeSlot.setEndTime(new LocalTime(11, 59));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("EARLYBIRD");
//        timeSlot.setTimeSlotName("Early Bird");
//        timeSlot.setTimeSlotDescription("Time of the Day early in the morning, when potential clients are/have waking up/woken up");
//        timeSlot.setIsInstant(Boolean.FALSE);
//        timeSlot.setSlotDiscount(0.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
//        timeSlots.add(timeSlot);
//
//        //LUNCHHOUR - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(1000);
//        timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(12, 0));
//        timeSlot.setEndTime(new LocalTime(16, 59));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("LUNCHHOUR");
//        timeSlot.setTimeSlotName("Lunch Hour");
//        timeSlot.setTimeSlotDescription("Lunch hour");
//        timeSlot.setIsInstant(Boolean.FALSE);
//        timeSlot.setSlotDiscount(0.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
//        timeSlots.add(timeSlot);
//
//        //RUSHHOUR - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(1200);
//        timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(17, 0));
//        timeSlot.setEndTime(new LocalTime(19, 59));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("RUSHHOUR");
//        timeSlot.setTimeSlotName("Rush Hour");
//        timeSlot.setTimeSlotDescription("Time of the Day in the evening when potential clients are/have leaving/left their work places");
//        timeSlot.setIsInstant(Boolean.FALSE);
//        timeSlot.setSlotDiscount(0.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
//        timeSlots.add(timeSlot);
//
//        //PRIME - SLOT
//        slotAdPrice = new Amounttype();
//        slotAdPrice.setCurrencycode("UGX");
//        slotAdPrice.setAmount(1500);
//        timeSlot = new AdTimeSlot();
//        timeSlot.setStartTime(new LocalTime(20, 0));
//        timeSlot.setEndTime(new LocalTime(22, 59));
//        timeSlot.setSlotAdPrice(slotAdPrice);
//        timeSlot.setTimeSlotCode("PRIME");
//        timeSlot.setTimeSlotName("Prime Time");
//        timeSlot.setTimeSlotDescription("Most potential clients get to be glued on their TVs at this time. An opporune moment to advertise");
//        timeSlot.setIsInstant(Boolean.FALSE);
//        timeSlot.setSlotDiscount(0.0f);
//        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
//        timeSlots.add(timeSlot);
//
//        customHibernate.saveBulk(timeSlots);
//
//    }
//
//    /**
//     *
//     * @return @throws MyCustomException
//     */
//    private String generate() throws MyCustomException {
//
//        String code = String.valueOf(HibernateUtils.generateIntegerID(customHibernate, AdArea.class, "areaCode"));
//        return code;
//    }
//
//    /**
//     * Generate Screen Id
//     *
//     * @param businessId
//     * @return
//     * @throws MyCustomException
//     */
//    public String generateScreenId(String businessId) throws MyCustomException {
//
//        //get the most recent Screen under this business
//        AdScreen recentScreen = customHibernate.getMostRecentRecord(AdScreen.class, "id", "adBusiness.businessId", businessId);
//        String incremStart;
//
//        if (recentScreen == null) {
//            logger.debug("recentScreen is null");
//
//            incremStart = NamedConstants.SCREEN_START_ID;
//        } else {
//            String idToIncrement = recentScreen.getScreenId();
//            int len = idToIncrement.length();
//            idToIncrement = idToIncrement.substring(len - 2); //e.g. if screenId is SASS01, substring will give us -> '01'
//
//            //generatorId = AlphaNumericIDGenerator.generateNextId(idToIncrement);
//            incremStart = NumericIDGenerator.generateNextId(idToIncrement);
//        }
//
//        String screenId = businessId + "-" + incremStart;
//
//        return screenId;
//
//    }
//
//    public void gummaaza() throws MyCustomException {
//        return;
//    }
//
//    /**
//     * Initialise Database
//     *
//     * @throws MyCustomException
//     */
//    public void initDB() throws MyCustomException {
//
//        if (screenLayoutsInitialised()) {
//            logger.debug("Database already initialised, skipping!");
//            return;
//        }
//
//        //screen layouts
//        addDisplayLayouts();
//
//        //screen sizes
//        addScreenSizes();
//
//        //time slots
//        addTimeSlots();
//
//        //audience types
//        addAudienceTypes();
//
//        //business types
//        addBusinessTypes();
//
//        //Guest user
//        addGuestUser();
//
//        //test user
//        addTestUser();
//
//        //Templates campaign user
//        addTemplateCampaignsUser();
//
//        // test advert client
//        addTestCampaignClient();
//
//        // test advert client
//        addGuestCampaignClient();
//
//        //Templates campaign client
//        addTemplateCampaignClient();
//
//        //add terminal -terminalId is got from DSM server database after syncing terminal to server
//        //AdTerminal terminal = addTerminal(1506182937, 1506182957, 1504710509, "230901364440706", "FORTEBET Terminal-1", "First pilot terminal - Original terminal - ForteBet", 13.0412658, 80.2338514); //Chenai - India -> 600017
//    }
}
