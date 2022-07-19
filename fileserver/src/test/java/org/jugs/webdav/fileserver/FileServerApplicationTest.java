/*
 * Copyright (c) 2022 by Oli B.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express orimplied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * (c)reated 15.07.22 by oboehm
 */
package org.jugs.webdav.fileserver;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-Test fuer {@link FileServerApplication} ...
 *
 * @author oboehm
 * @since 15.07.22
 */
class FileServerApplicationTest {

    private final FileServerApplication application = new FileServerApplication();

    @Test
    void getClasses() {
        Set<Class<?>> classes = application.getClasses();
        assertFalse(classes.isEmpty());
    }

    @Test
    void getSingletons() {
        Set<Object> singletons = application.getSingletons();
        assertFalse(singletons.isEmpty());
    }

}