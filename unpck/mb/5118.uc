class 5118 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect54
		AttachOn=AM_LA
		offset=(X=0.000000,Y=200.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect55
		AttachOn=AM_LA
		SpawnDelay=0.200000
		offset=(X=20.000000,Y=-200.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect62
		AttachOn=AM_LA
		SpawnDelay=0.300000
		offset=(X=90.000000,Y=100.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect63
		AttachOn=AM_LA
		SpawnDelay=0.600000
		offset=(X=110.000000,Y=-70.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect64
		AttachOn=AM_LA
		SpawnDelay=0.100000
		offset=(X=-120.000000,Y=100.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect65
		AttachOn=AM_LA
		SpawnDelay=0.400000
		offset=(X=-90.000000,Y=-100.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect67
		AttachOn=AM_LA
		SpawnDelay=0.200000
		offset=(X=100.000000,Y=280.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect68
		AttachOn=AM_LA
		SpawnDelay=0.700000
		offset=(X=100.000000,Y=-270.000000,Z=-81.000000)
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect69
		AttachOn=AM_LA
		SpawnDelay=0.300000
		offset=(X=280.000000,Y=100.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect70
		AttachOn=AM_LA
		SpawnDelay=0.400000
		offset=(X=-275.000000,Y=-50.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect71
		AttachOn=AM_LA
		SpawnDelay=0.200000
		offset=(X=-220.000000,Y=220.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect72
		AttachOn=AM_LA
		SpawnDelay=0.600000
		offset=(X=220.000000,Y=-220.000000,Z=-81.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect76
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-70.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832_new_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect66
		AttachOn=AM_LA
		bRelativeToCylinder=False
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.bl_curse_poison_ta'
		bOnMultiTarget=True
	End Object
	Desc="사이렌전용캔슬" //Siren -only cancel
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect54',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect55',SpecificStage=0)
	CastingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect62',SpecificStage=0)
	CastingActions(3)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect63',SpecificStage=0)
	CastingActions(4)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect64',SpecificStage=0)
	CastingActions(5)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect65',SpecificStage=0)
	CastingActions(6)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect67',SpecificStage=0)
	CastingActions(7)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect68',SpecificStage=0)
	CastingActions(8)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect69',SpecificStage=0)
	CastingActions(9)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect70',SpecificStage=0)
	CastingActions(10)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect71',SpecificStage=0)
	CastingActions(11)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect72',SpecificStage=0)
	CastingActions(12)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect76',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect66',SpecificStage=0)
}