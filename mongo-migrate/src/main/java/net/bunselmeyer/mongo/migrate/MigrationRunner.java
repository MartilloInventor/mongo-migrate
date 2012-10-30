/*
 * Copyright 2012 William L. Bunselmeyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.bunselmeyer.mongo.migrate;

import com.mongodb.DB;

public class MigrationRunner {

    private final DB _db;

    MigrationRunner(DB db) {
        _db = db;
    }

    public void migrate() {

    }

    public void migrate(Class<? extends Migration> migration) {
        try {
            migration.newInstance().up(_db);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(Class<? extends Migration> migration) {
        try {
            migration.newInstance().down(_db);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(int steps) {

    }
}
