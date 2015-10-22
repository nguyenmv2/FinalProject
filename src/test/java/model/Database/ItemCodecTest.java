package model.Database;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import model.Core.Item;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by My_Nguyen on 10/22/15.
 */
public class ItemCodecTest {
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();
    private static String collectionName = "Test Collection";
    private MongodExecutable _mongodExe;
    private MongodProcess _mongod;
    private MongoClient _mongo;
    private MongoDatabase testDB;

    public MongoClientOptions loadCustomCodecIntoDB() {
        Codec<Document> defaultDocCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        ModifierCodec modifierCodec = new ModifierCodec(defaultDocCodec);
        ItemCodec itemCodec = new ItemCodec(defaultDocCodec);
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(modifierCodec),
                CodecRegistries.fromCodecs(itemCodec)
        );
        MongoClientOptions options = MongoClientOptions.builder()
                .codecRegistry(codecRegistry)
                .build();
        return options;
    }

    @Before
    public void beforeTest() throws Exception {

        _mongodExe = starter.prepare(new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(12345, Network.localhostIsIPv6()))
                .build());
        _mongod = _mongodExe.start();
        _mongo = new MongoClient("localhost:12345", loadCustomCodecIntoDB());
        testDB = _mongo.getDatabase("TestDB");
        testDB.createCollection("Test Collection");
    }

//    @After
//    public void afterTest() {
//        if (this._mongod != null) {
//            this._mongod.stop();
//            this._mongodExe.stop();
//        }
//    }

    @Test
    public void addOneItemWithoutMods() {
        MongoCollection<Item> testCollection = testDB.getCollection(collectionName, Item.class);
        Item testItem = new Item();
        testCollection.insertOne(testItem);
        Item itemFromDB = testCollection.find(testItem).first();
        testCollection.find().forEach((Block<Item>) f -> System.out.println(f));
        assertTrue(testItem.equals(itemFromDB));
    }
}
