/*
 * Copyright 2019 Spotify AB
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

package magnolify.guava.test

import com.google.common.hash.Funnel
import magnolify.test.Simple._

object ScopeTest {
  object Auto {
    import magnolify.guava.auto._
    implicitly[Funnel[Integers]]
  }

  object Semi {
    import magnolify.guava.semiauto._
    FunnelDerivation[Integers]
  }
}
