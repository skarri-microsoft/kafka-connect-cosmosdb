/**
  * The MIT License (MIT)
  * Copyright (c) 2016 Microsoft Corporation
  *
  * Permission is hereby granted, free of charge, to any person obtaining a copy
  * of this software and associated documentation files (the "Software"), to deal
  * in the Software without restriction, including without limitation the rights
  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  * copies of the Software, and to permit persons to whom the Software is
  * furnished to do so, subject to the following conditions:
  *
  * The above copyright notice and this permission notice shall be included in all
  * copies or substantial portions of the Software.
  *
  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  * SOFTWARE.
  */
package com.microsoft.azure.cosmosdb.kafka.connect

import com.microsoft.azure.cosmosdb.{ConnectionPolicy, ConsistencyLevel}

case class CosmosDBClientSettings(
                                   endpoint:String,
                                   masterKey:String,
                                   db:String,
                                   coll:String,
                                   connectionPolicy:ConnectionPolicy,
                                   consistencyLevel:ConsistencyLevel
                                 )

object CosmosDBClientSettings
{
  def getLocalHost:CosmosDBClientSettings={

    val cosmosDBClientSettings=new CosmosDBClientSettings(
      "https://localhost:8081",
      masterKey = "C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==",
      db="db",
      coll="coll",
      connectionPolicy = ConnectionPolicy.GetDefault(),
      consistencyLevel = ConsistencyLevel.Eventual
    )
    cosmosDBClientSettings
  }

  def getDefault(endpoint:String,masterKey:String,db:String,coll:String):CosmosDBClientSettings=
  {
    val cosmosDBClientSettings=new CosmosDBClientSettings(
      endpoint,
      masterKey,
      db,
      coll,
      connectionPolicy = ConnectionPolicy.GetDefault(),
      consistencyLevel = ConsistencyLevel.Eventual
    )
    cosmosDBClientSettings
  }
}
