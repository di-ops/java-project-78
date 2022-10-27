build:
	make -C app build

setup:
	make -C app setup

clean:
	make -C app report

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

install:
	make -C app install

check-updates:
		make -C app check-updates

.PHONY: build