package com.oomagnitude.filesystem

import com.oomagnitude.server.Accessor

import scala.concurrent.ExecutionContextExecutor

class FilesystemAccessor(implicit override val executionContext: ExecutionContextExecutor) extends Accessor with FilesystemExperimentAccessor with FilesystemMetadataAccessor