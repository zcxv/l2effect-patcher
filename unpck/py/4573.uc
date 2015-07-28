class 4573 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect11
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.at_sonic_blast_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_sonic_blast_ta'
	End Object
	Desc="NPC Sonic Blaster" //NPC Sonic Blaster
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect11',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
	FlyingTime=0.400000
}