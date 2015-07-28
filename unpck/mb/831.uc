class 831 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect36
		AttachOn=AM_LA
		offset=(X=0.000000,Y=100.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect37
		AttachOn=AM_LA
		SpawnDelay=0.300000
		offset=(X=10.000000,Y=-100.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect38
		AttachOn=AM_LA
		SpawnDelay=0.600000
		offset=(X=45.000000,Y=50.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect39
		AttachOn=AM_LA
		SpawnDelay=0.100000
		offset=(X=55.000000,Y=-35.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect40
		AttachOn=AM_LA
		SpawnDelay=0.200000
		offset=(X=-60.000000,Y=50.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect41
		AttachOn=AM_LA
		SpawnDelay=0.400000
		offset=(X=-45.000000,Y=-50.000000,Z=-20.500000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u831_b'
	End Object
	Desc="사이렌자기주변버프캔슬" //Sirens around his buff cancel
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect36',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect37',SpecificStage=0)
	CastingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect38',SpecificStage=0)
	CastingActions(3)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect39',SpecificStage=0)
	CastingActions(4)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect40',SpecificStage=0)
	CastingActions(5)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect41',SpecificStage=0)
}