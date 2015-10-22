package model.Database;

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
import model.Core.Modifier;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by My_Nguyen on 10/17/15.
 */
public class ModifierCodecTest {
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();
    private static String collectionName = "Test Collection";
    private MongodExecutable _mongodExe;
    private MongodProcess _mongod;
    private MongoClient _mongo;
    private MongoDatabase testDB;

    public MongoClientOptions loadCustomCodecIntoDB() {
        Codec<Document> defaultDocCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
        ModifierCodec modifierCodec = new ModifierCodec(defaultDocCodec);
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(modifierCodec)
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

    @After
    public void afterTest() {
        if (this._mongod != null) {
            this._mongod.stop();
            this._mongodExe.stop();
        }
    }

    @Test
    public void createOneCollection() {
        Modifier m = new Modifier();
        MongoCollection<Modifier> collection = testDB.getCollection(collectionName, Modifier.class);
        collection.insertOne(m);
        Modifier resultFromDB = collection.find(m).first();
        System.out.println(resultFromDB.getId());
        assertTrue(m.equals(resultFromDB));
    }


}
